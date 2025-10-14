package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/xml")
@RequiredArgsConstructor
public class XmlController {
    private final XmlMapper xmlMapper;

    // 1. 등록
    @PostMapping("")
                        // <?> : 제네릭타입에 ? 넣으면 모든 타입을 지정한다. 와일드카드
    public ResponseEntity<?>save(@RequestBody XmlDto dto){
        System.out.println("dto = " + dto); // save 실행 전
        xmlMapper.save(dto);
        System.out.println("dto = " + dto); // save 실행 후
        return ResponseEntity.ok(true); //제네릭 ? 이므로 모든 자료가 대입된다.
    }//func end

    // 2. 전체조회
    @GetMapping("")
    public ResponseEntity<?>findAll(){
        List<XmlDto> result = xmlMapper.findAll();
        return ResponseEntity.ok(result);
    }//func end

    // 3. 개별 조회
    @GetMapping("/find")
    public ResponseEntity<XmlDto>find(@RequestParam int sno){
        XmlDto result =  xmlMapper.find(sno);
        return ResponseEntity.ok(result);
    }//func end

    // 4. 개별 삭제
    @DeleteMapping("")
    public ResponseEntity<Integer>delete(@RequestParam int sno){
        int result = xmlMapper.delete(sno);
        return ResponseEntity.ok(result);
    }//func end

    // 5. 개별수정
    @PutMapping("")
    public ResponseEntity<Integer>update(@RequestBody XmlDto xmlDto){
        int result = xmlMapper.update(xmlDto);
        return ResponseEntity.ok(result);
    }//func end

    // 6. IF 동적쿼리
    @GetMapping("/find2")
    public ResponseEntity<List<XmlDto>>query2(@RequestParam int kor){
        List<XmlDto> result = xmlMapper.query2(kor);
        return ResponseEntity.ok(result);
    }//func end

    // 7. IF 동적쿼리2
    @GetMapping("/find3")
    public ResponseEntity<List<XmlDto>>query3(@RequestParam String name,@RequestParam int math){
        List<XmlDto> result = xmlMapper.query3(name,math);
        return ResponseEntity.ok(result);
    }

    // 8. 여러개 학생 등록
    @PostMapping("/add")
    public ResponseEntity<Integer> saveAll(@RequestBody List<XmlDto>dto){
        int result = xmlMapper.saveAll(dto);
        return ResponseEntity.ok(result);
    }




}//class end
