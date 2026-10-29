package seg3x02.calculatorapi

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `add endpoint returns sum`() {
        mockMvc.get("/calculator/add/5/3")
            .andExpect { status { isOk() } }
            .andExpect { content { string("8.0") } }
    }

    @Test
    fun `subtract endpoint returns difference`() {
        mockMvc.get("/calculator/subtract/10/4")
            .andExpect { status { isOk() } }
            .andExpect { content { string("6.0") } }
    }

    @Test
    fun `multiply endpoint returns product`() {
        mockMvc.get("/calculator/multiply/2/6")
            .andExpect { status { isOk() } }
            .andExpect { content { string("12.0") } }
    }

    @Test
    fun `divide endpoint returns quotient`() {
        mockMvc.get("/calculator/divide/9/3")
            .andExpect { status { isOk() } }
            .andExpect { content { string("3.0") } }
    }

    @Test
    fun `divide by zero returns bad request`() {
        mockMvc.get("/calculator/divide/5/0")
            .andExpect { status { isBadRequest() } }
    }
}
