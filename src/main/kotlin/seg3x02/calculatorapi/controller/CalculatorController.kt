package seg3x02.calculatorapi.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calculator")
@CrossOrigin("http://localhost:4200")
@Tag(name = "Calculator", description = "Operations for basic arithmetic")
class CalculatorController {

    @GetMapping("/add/{number1}/{number2}")
    @Operation(summary = "Add two numbers")
    fun add(@PathVariable number1: Double, @PathVariable number2: Double): Double {
        return number1 + number2
    }

    @GetMapping("/subtract/{number1}/{number2}")
    @Operation(summary = "Subtract two numbers")
    fun subtract(@PathVariable number1: Double, @PathVariable number2: Double): Double {
        return number1 - number2
    }

    @GetMapping("/multiply/{number1}/{number2}")
    @Operation(summary = "Multiply two numbers")
    fun multiply(@PathVariable number1: Double, @PathVariable number2: Double): Double {
        return number1 * number2
    }

    @GetMapping("/divide/{number1}/{number2}")
    @Operation(summary = "Divide two numbers")
    fun divide(@PathVariable number1: Double, @PathVariable number2: Double): Double {
        if (number2 == 0.0) {
            throw IllegalArgumentException("Cannot divide by zero")
        }
        return number1 / number2
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentException(ex: IllegalArgumentException): Map<String, String> {
        return mapOf("error" to (ex.message ?: "Unable to process request"))
    }
}
