package online.northal;

import online.northal.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OpsyluxApplication.class)
public class JwtUtilTest {

    @Autowired
    private JwtUtil jwtUtil;


    @Test
    public void test() {
        System.out.println(this.jwtUtil.generateToken(1L, "North"));
    }
}
