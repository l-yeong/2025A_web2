package example2.day01;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    // 1. C, 등록
    public ExamEntity post(ExamEntity examEntity){ // 1. 저장할 엔티티를 (매개변수) 받는다.
        // 2. .save() 리포지토리의 저장 메소드, 저장성공시 성공된 엔티티 반환
        ExamEntity saveEntity = examRepository.save(examEntity); // insert 자동 처리

        //엔티티 객체(레코드=행) 엔티티(테이블)
        return saveEntity;
    }//func end

    // 2. R, 전체 조회
    public List<ExamEntity> get(){
        // 1. .findAll(), 리포지토리의 전체조회 메소드, 모든 엔티티객체를 반환 한다.
        List<ExamEntity> entityList = examRepository.findAll(); // select 자동처리
        return entityList;
    }//func end

    // 3-1. U, 특정한 엔티티 수정, *비권장*
    public ExamEntity put(ExamEntity examEntity){
        //1. 수정할 엔티티 매개변수로 받는다. pk포함
        //2. save(수정할엔티티) :  만약에 지정한엔티티에 PK가 없으면 *생성, 존재하면 *수정
        return examRepository.save(examEntity);
    }//func end

    // 3-2. U, 특정한 엔티티 수정
    @Transactional
    public  ExamEntity put2(ExamEntity examEntity){
        //1. 수정할 엔티티 조회한다. findAll(), findById(PK번호)
        Optional<ExamEntity> optional =examRepository.findById(examEntity.getCol1());
        //2. Optional 이란? 자바에 자주 발생 하는 nullPointer 예외를 감싼 클래스
        // 즉] null 값에 대한 안전하게 유효성 기능 제공한다.
        if(optional.isPresent()) { // .isPresent() : 본문이 존재하는지 검사
            ExamEntity entity = optional.get(); // .get() : 만약에 결과에 entity 존재하면 entity 꺼내기
            entity.setCol2(examEntity.getCol2()); //setter 이용한 엔티티 값 수정
            entity.setCol3(examEntity.getCol3()); //setter 이용한 엔티티 값 수정
            return entity;
        }//if end
        return examEntity;
    }//func end



    // 4.D, 삭제
    public boolean delete(int col1){
        //1. 삭제할 pk번호 받는다
        //2. deleteById(pk번호)
        examRepository.deleteById(col1);
        return true;
    }

}//class end
