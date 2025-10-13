package example.day12;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/axios")
@RequiredArgsConstructor
public class AxiosController {
    // [1]
    @GetMapping("")
    public int axios1(){
        System.out.println("AxiosController.axios1");
        return 10;
    }//func end

    //[2]
    @PostMapping("/login")
    public boolean axios2(@RequestBody Map<String,String>map, HttpSession session){
        String id = map.get("id");
        session.setAttribute("loginId",id); // 2-1 로그인 세션의 속성 등록
        return true;
    }//func end

    //[3]
    @GetMapping("/info")
    public boolean axios3(HttpSession session){
        Object object = session.getAttribute("loginId");
        if(object==null) return false; //비로그인 중
        return true; //로그인 중

    }

    //[4]
    @PostMapping("/form")
    public boolean axios4(@RequestParam Map<String,String>map){
        System.out.println("AxiosController.axios4");
        System.out.println("map = " + map);
        return true;
    }

    //[5]
    @PostMapping("/formData")
    public boolean axios5(@RequestBody MultipartFile file){
        System.out.println("AxiosController.axios5");
        System.out.println("file = " + file);
        return true;
    }

}//class end

@AllArgsConstructor
@NoArgsConstructor
@Data
class AxiosDto{
    private String id;
    private String pwd;
}
