package example2.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;


    //도서 등록
    public LibraryEntity bookPost(LibraryEntity libraryEntity){
        LibraryEntity postEntity = libraryRepository.save(libraryEntity);
        System.out.println(postEntity);
        return postEntity;
    }//func end

    //도서 조회
    public List<LibraryEntity> bookGet(){
        List<LibraryEntity> print  = libraryRepository.findAll();
        return print;
    }//func end

    //도서 수정
    @Transactional
    public LibraryEntity bookUpdate(LibraryEntity libraryEntity){

        //수정할 엔티티 조회
        Optional<LibraryEntity> optional = libraryRepository.findById(libraryEntity.getBno());

        if(optional.isPresent()){
            LibraryEntity library = optional.get();
            library.setTitle(libraryEntity.getTitle()); // setter 이용한 엔티티 값 수정
            library.setAuthor(libraryEntity.getAuthor()); // setter 이용한 엔티티 값 수정
            library.setPublisher(libraryEntity.getPublisher()); // setter 이용한 엔티티 값 수정
            return library;
        }//if end
        return libraryEntity;
    }//func end

    //도서 삭제
    public boolean bookDelete(int bno){
        libraryRepository.deleteById(bno);
        return true;
    }//func end

}//class end
