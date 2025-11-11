package example2.day04.service;

import example2.day04.dto.TodoDto;
import example2.day04.entity.TodoEntity;
import example2.day04.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    // 전체 조회
    public List<TodoDto> findAll(){
        return todoRepository.findAll()
                .stream().map(TodoEntity::toDto)
                .collect(Collectors.toList());
    }//func end

    // 개별조회
    public TodoDto findById(int id){
        Optional<TodoEntity> optional= todoRepository.findById(id);
        if(optional.isPresent()){
            TodoEntity todoEntity = optional.get();
            return todoEntity.toDto();
        }
        System.out.println(optional);
        return null;
    }//func end

    // 개별수정
    public TodoDto update(TodoDto todoDto){
        Optional<TodoEntity> optional = todoRepository.findById(todoDto.getId());
        if(optional.isPresent()){
            TodoEntity entity = optional.get();
            //JPA는 수정함수가 별도로 존재하지않고 setter 이용한 영속성 수정
            entity.setTitle(todoDto.getTitle());
            entity.setContent(todoDto.getContent());
            entity.setDone(todoDto.isDone()); // boolean setter는 isXXX
            return entity.toDto();
        }
        return null;
    }//func end

    // 개별 삭제
    public boolean delete(int id){
        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }//func end

    //[1] TodoRepository 2-1,3-1
    public List<TodoDto> query1(String title){

        //2-1 내가 만든 명명 규칙 사용한 쿼리 메소드
        List<TodoEntity>result = todoRepository.findByTitle(title);
        System.out.println("result = " + result);

        //3-1 내가 만든 네이티브 쿼리 메소드
        List<TodoEntity> result2 = todoRepository.query1(title);
        System.out.println("result2 =" + result2);

        //*
        return result2.stream()
                .map(TodoEntity::toDto)
                .collect(Collectors.toList());
    }//func end

    //[2] TodoRepository 2-2,3-2
    public List<TodoDto> query2(String title, String content){

        //2-2 내가 만든 명명규칙 사용한 쿼리 메소드
        List<TodoEntity> result1 = todoRepository.findByTitleAndContent(title,content);
        System.out.println("[2-2]result1="+result1);

        //3-2 내가 만든 네이티브 쿼리 메소드
        List<TodoEntity> result2 = todoRepository.query2(title,content);
        System.out.println("[3-2]result2="+result2);
        return result2.stream()
                .map(TodoEntity::toDto)
                .collect(Collectors.toList());
    }//func end

    //[3] TodoRepository 2-3,3-3
    public List<TodoDto> query3(String title){

        //2-3 내가 만든 명명규칙 사용한 쿼리 메소드
        List<TodoEntity> result1 = todoRepository.findByTitleContaining(title);
        System.out.println("[2-3]result1 = "+result1);

        //3-3 내가 만든 네이티브 쿼리 메소드
        List<TodoEntity> result2 = todoRepository.query3(title);
        System.out.println("[3-3]result1="+result2);
        return result2.stream()
                .map(TodoEntity::toDto)
                .collect(Collectors.toList());
    }//func end

    //[4]
    public Page<TodoDto> page1 (int page,int size){
        //4-1 : 페이징 처리 옵션 설정, PageRequest
        //PageRequest.of(조회할페이지번호,조회할페이지당데이터수, Sort.by(Sort.Direction.DESC),"정렬속성명")
        PageRequest pageRequest =
            PageRequest.of(page-1,size,Sort.by(Sort.Direction.DESC,"id"));
            // Page-1 : JPA는 페이지번호를 0부터 시작함ㅇ로 1페이지가 0이고 2페이지가 1으로 처리됨에 -1
            // size : 현재 (한)페이지에 조회할 자료 개수, 1페이지에서 3개 조회
            // Sort.by(Sort.Direction.ASC,"id") : id속성(컬럼)
        //4-2 : 조회한다. .findAll(페이지객체);, Page<>타입으로 반환 한다.
        Page<TodoEntity> result = todoRepository.findAll(pageRequest);
            // Page : 페이징 처리 결과를 담는 인터페이스 타입, 다양한 페이징 결과 제공 한다
        //4-3 : 조회 결과 반환, Page타입은 *스트림*을 기본적으로 제공한다
        return result.map(TodoEntity::toDto);
    } //func end

    //[5]
    public Page<TodoDto> page2(String keyword,int page, int size){
        PageRequest pageRequest = PageRequest.of(page-1,size,Sort.by(Sort.Direction.DESC,"id"));
        Page<TodoEntity> result;
        if(keyword == null || keyword.isBlank()){ // 5-1 : 만약에 검색이 없으면 전체조회
            result = todoRepository.findAll(pageRequest); //전체 조회
        }else{ // 5-2 : 검색이 있으면 검색 조회
            result =  todoRepository.findByTitleContaining(keyword,pageRequest);
        }//if end

        //result 내 모든 자료들을 하나씩 toDto 함수들 호출하여 반환값들을 새로운 리스트에 변환한다.
        return result.map(TodoEntity::toDto);
    }//func end

}//class end
//다형성이란? 특정 타입이 다양한 타입으로 변환 가능한 성질: 상속, 구현