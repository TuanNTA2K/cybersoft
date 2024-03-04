package com.cybersoft.demospringboot04;

import com.cybersoft.demospringboot04.entity.DemoEntity;
import com.cybersoft.demospringboot04.entity.EmployeesEntity;
import com.cybersoft.demospringboot04.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    Bước 1(*): Định nghĩa đường dẫn
    Bước 2(*): Nhận các tham số mà mà người dùng (client) truyền lên để đem đi xử lý
    Bước 3(*): Kết nối được csdl
    BƯớc 4 : Thực thi các câu truy vấn liên tới yêu cầu của chức năng
    Bước 5 : Trả kết quả ra giao diện
 */

//@Controller dùng để đánh dầu cho spring boot biết class này dùng để khai báo và định nghĩa đường dẫn
//@RequestMapping : định nghĩa đường dẫn
@Controller
@RequestMapping("/hello")
public class HelloController {
    // Phương thức
    /*
      Đối với tên tham số đường dẫn nên viết thường toàn bộ
      Get: tham số sẽ đc truyền trực tiếp trên đường dẫn URL
      -client: ?tên_tham_số = giá_trị_của_tham_số&tên_tham_số = giá_trị_của_tham_số
      ví dụ: http://localhost:8080/hello?hoten=Nguyen Van A
      - server : quy định tham số @RequestParam kiểu_dữ_liệu tên_tham_số


    //  Post: Tham số sẽ được truyền ngầm
    - client : phải truyền thông qua thẻ form hoặc tự code gọi đường dẫn với phương thức POST
    - server : giống như GET
    */
    /*
        * 4 Cách để đưa CLASS khởi tạo sẵn giá trị lưu trữ trên IOC
        - @Bean : + Để tạo class gán sẵn giá trị thì sử dụng function có giá trị trở về là 1 class( đối tượng)
                  + khi sử dụng tham số thì spring boot sẽ tìm kiểu dữ liệu của tham số khai báo trong IOC
        - @Component
        - @Service
        - @Repository
     */
    @Autowired
    //@Qualifier("demo2") //lấy class có tên @Bean là demo2 trên IOC
    private DemoEntity demoEntity;

    @Autowired
    private EmployeesRepository employeesRepository;

    @GetMapping("")
    public String hello(){
        List<EmployeesEntity> list = employeesRepository.findByEmployeeNameAndSalary("John Doe", 60000);

        for (EmployeesEntity data : list) {
            System.out.println("Kiểm tra: " + data.getEmployeeName());
        }
        return "hello";
    }

    @GetMapping("/java")
    // cách 2: @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloJava(@RequestParam(required = false) String loichao, @RequestParam int age) {
        //hàm này sẽ xử lý logic code cho đường dẫn /hello/java
        System.out.println("Kiểm tra tham số: " + loichao + " tuổi nhân viên" + age);
        //trả ra giao diện của file hello.html (thymleaf hỗ trợ sẵn)
        return "hello";
    }
    //tạo đường dẫn có tên là /maytinh với phương thức GET, yêu cầu người dùng truyền lên 2 tham số với tên tham số là soA
    // và soB. Thực hiện phép tính tổng của soA và soB
    @PostMapping("/welcome")
    public String welcome(@RequestParam String tendangnhap, @RequestParam String matkhau){
        System.out.println("Ten dang nhap: " + tendangnhap + " Mat khau: " + matkhau);
        return "welcome";
    }

    @GetMapping("/pathvariable/{hello}")
    public String pathVariable(@PathVariable String hello){
        System.out.println("Kiem tra path: " + hello);
        return "hello";
    }
}
