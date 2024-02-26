import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

fun main() {
//    runBlocking {
//        println("Weather forecast")
//        delay(1000)
//        println("Sunny")
//    }

//    runBlocking {
//        println("Weather forecast")
//        printForecast()
//        printTemperature()
//    }

//    val time = measureTimeMillis {
//        runBlocking {
//            println("Weather forecast")
//            printForecast()
//            printTemperature()
//        }
//    }
//    println("Execution time: ${time / 1000.0} seconds")

//    runBlocking {
//        println("Weather forecast")
//        launch {
//            printForecast()
//        }
//        launch {
//            printTemperature()
//        }
//    }

//    val time = measureTimeMillis {
//        runBlocking {
//            println("Weather forecast")
//            launch {
//                printForecast()
//            }
//            launch {
//                printTemperature()
//            }
//        }
//    }
//    println("Execution time: ${time / 1000.0} seconds")


//    runBlocking {
//        println("Weather forecast")
//        launch {
//            printForecast()
//        }
//        launch {
//            printTemperature()
//        }
//        println("Have a good day!")
//    }


//    runBlocking {
//        println("Weather forecast")
//        val forecast: Deferred<String> = async {
//            getForecast()
//        }
//        val temperature: Deferred<String> = async {
//            getTemperature()
//        }
//        println("${forecast.await()} ${temperature.await()}")
//        println("Have a good day!")
//    }

    runBlocking {
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }

//    runBlocking {
//        println("Weather forecast")
//        try {
//            println(getWeatherReport())
//        } catch (e: AssertionError) {
//            println("Caught exception in runBlocking(): $e")
//            println("Report unavailable at this time")
//        }
//        println("Have a good day!")
//    }

    runBlocking {
        println("${Thread.currentThread().name} - runBlocking function")
        launch {
            println("${Thread.currentThread().name} - launch function")
            withContext(Dispatchers.Default) {
                println("${Thread.currentThread().name} - withContext function")
                delay(1000)
                println("10 results found.")
            }
            println("${Thread.currentThread().name} - end of launch function")
        }
        println("Loading...")
    }
}

//suspend fun printForecast() {
//    delay(1000)
//    println("Sunny")
//}

//suspend fun printTemperature() {
//    delay(1000)
//    println("30\u00b0C")
//}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

//suspend fun getTemperature(): String {
//    delay(1000)
//    return "30\u00b0C"
//}



suspend fun getTemperature(): String {
    delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async {
        try {
            getTemperature()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    }

    "${forecast.await()} ${temperature.await()}"
}