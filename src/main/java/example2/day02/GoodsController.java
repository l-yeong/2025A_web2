package example2.day02;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/goods")
public class GoodsController {
    private final GoodsService goodsService;

    // 1.저장
    @PostMapping
    public ResponseEntity<?> goodsSave(@RequestBody GoodsDto goodsDto){
        return ResponseEntity.ok(goodsService.goodsSave(goodsDto));
    }//func end

    // 2.전체조회
    @GetMapping("/findall")
    public ResponseEntity<?> goodsAll(){
        return ResponseEntity.ok(goodsService.goodsAll());
    }//func end

    // 3.개별조회
    @GetMapping("/find")
    public ResponseEntity<?> goodsFind(@RequestParam int gno){
        return ResponseEntity.ok(goodsService.goodsFind(gno));
    }//func end

    // 4.개별삭제
    @DeleteMapping
    public ResponseEntity<?> goodsDelete(@RequestParam int gno){
        return ResponseEntity.ok(goodsService.goodsDelete(gno));
    }//func end

    // 5.개별 수정
    @PutMapping
    public ResponseEntity<?> goodsUpdate(@RequestBody GoodsDto goodsDto){
        return ResponseEntity.ok(goodsService.goodsUpdate(goodsDto));
    }//func end
}//class end
