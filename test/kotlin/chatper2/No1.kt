package test.kotlin.chatper2

enum class color {
    RED, ORANGE, YELLOW, GREEEN, INDIGO, BLUE
}

enum class Color(var r: Int, var g: Int, var b: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255);

    fun rgb() = (r * 256 + g) * 256 + b;
}

fun getMnemonic(color: Color) =
        when (color) {
            Color.BLUE -> "blue"
            Color.RED -> "red"
            Color.GREEN -> "green"
        }


fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println(" '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }

    return null
}

fun fortest1() {
    val items = listOf<String>("apple", "banana", "refresh")
    for (item in items) {
        println(item)
    }
}

fun fortest2() {
    val items = listOf("apple", "bannar", "orange")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun whileTest() {
    val items = listOf("apple", "bannar", "orange")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            is Long -> "Long"
            "Hello" -> "Hello"
            !is String -> "Not a String"
            else -> "unknow"
        }

fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello,  $name!")

    println(Color.BLUE.rgb())

    println(getMnemonic(Color.GREEN))

    printSum(-1, 8)

    var a = 1;
    val s1 = " a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

    printProduct("a", "7")

    fortest1()
    fortest2()
    whileTest()
    println(describe("Hello"))

    val x1 = 10
    val y = 9
    if (x1 in 1..y + 1) {
        println("fits in range")
    }

    for (x in 1..5) {
        print(x)
    }

    for (x in 1..10 step 2) {
        print(x)
    }

    for (x in 9 downTo 0 step 3) {
        println(x)
    }

    val items = setOf<String>("apple", "banana", "kiwifruit")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val rectangle = Rectangle(5.0, 2.0)
    val triangle = Triangle(3.0, 4.0, 5.0)
    println(rectangle.calculateArea())
    println(triangle.calculateArea())

    

}

abstract class Shape(val sides: List<Double>) {
    val parameter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

interface RectangleProperties{
    val isSquare: Boolean
}

class Rectangle(val hight: Double, val length: Double) : Shape(listOf(hight, length, hight, length)), RectangleProperties {
    override fun calculateArea(): Double {
        return hight * length
    }

    override val isSquare: Boolean
        get() = length == hight
}

class Triangle(var sideA : Double, var sideB : Double, var sideC: Double): Shape(listOf(sideA, sideB, sideC)){
    override fun calculateArea(): Double {
        val s = parameter / 2
        return Math.sqrt(s * ( s - sideA) * ( s - sideB) * ( s - sideC))
    }

}