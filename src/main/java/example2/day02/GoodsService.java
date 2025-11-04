package example2.day02;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GoodsService {
    private final GoodsRepository goodsRepository;

    //등록
    public GoodsDto goodsSave(GoodsDto goodsDto){
        //1. 저장할 dto 매개변수로 받는다
        GoodsEntity entity = goodsDto.toEntity(); // 2. 저장할 dto를 entity 반환 한다.
        GoodsEntity savedEntity = goodsRepository.save(entity); // 3. .save()이용한 엔티티 영속성
        // 4. 만약에 pk가 생성 되었으면 생성된 엔티티를 dto 변환하여 반환
        if(savedEntity.getGno() >= 0){return savedEntity.toDto();}
        return goodsDto;
    }// func end

    //조회
    public List<GoodsDto> goodsAll(){
        List<GoodsEntity> goodsEntityList = goodsRepository.findAll(); // 1. 모든 엔티티를 조회
        // 2. 모든 엔티티를 DTO로 변환
        // 방법1
        //List<GoodsDto> goodsDtoList = new ArrayList<>();
        //for(int i=0; i<goodsEntityList.size(); i++){
        //    GoodsEntity entity = goodsEntityList.get(i); // i번째 엔티티 꺼내서
        //    goodsDtoList.add(entity.toDto()); //엔티티를 dto로 변환 후 리스트에 저장
        //}//for end

        // 방법2 : 스트림API
        List<GoodsDto> goodsDtoList = goodsRepository.findAll()
                .stream().map(GoodsEntity :: toDto)
                .collect(Collectors.toList());
        return goodsDtoList;
    }//func end

    //개별조회
    public GoodsDto goodsFind(int gno){
        // 1. 개별 조회할  gno의 엔티티 조회한다.
        Optional<GoodsEntity> optional = goodsRepository.findById(gno);
        if(optional.isPresent()) {// 2. 조회 결과가 있으면
            GoodsEntity entity = optional.get(); // 3. 엔티티 꺼내기
            return entity.toDto(); //4. 엔티티를 dto로 반환한다
        }//if end
        return null;
    }//func end

    // 삭제
    public boolean goodsDelete(int gno){
        if(goodsRepository.existsById(gno)){ //.existsById(PK값) : pk값이 존재하면 true 없으면 false;
            goodsRepository.deleteById(gno);
        }//if end
        return true;
    }//func end

    //수정
    public GoodsDto goodsUpdate(GoodsDto goodsDto){
        Optional<GoodsEntity> optional = goodsRepository.findById(goodsDto.getGno()); //수정할 엔티티 조회
        if(optional.isPresent()){
            GoodsEntity entity = optional.get(); // 영속화된 엔티티 꺼내기
            entity.setGname(goodsDto.getGname());
            entity.setGprice(goodsDto.getGprice());
            entity.setGdesc(goodsDto.getGdesc());
            return entity.toDto(); //수정된 엔티티를 dto로 변환 후 반환
        }//if end
        return goodsDto;
    }//func end

}//class end
