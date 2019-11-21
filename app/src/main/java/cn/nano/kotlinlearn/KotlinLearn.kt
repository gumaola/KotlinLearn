package cn.nano.kotlinlearn

import java.util.*

/**
 * Kotlin主函数入口
 */
fun main() {
//    println("Hello world!")
//    readList()
//    readList2()
//    function(1, 2)
//    woman().work()
    world.checkAge(19)
}


/**
 * sum
 */

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

/**
 *无返回函数
 */
fun unit(a: Int): Unit {}

/**
 *函数内引用
 */

fun math(a: Int, b: Int) {
    println("a = $a, b= $b, sum = ${a + b}")
}

/**
 *字符串模板
 */

fun char() {
    var a = "a"
    val b = "a is $a"

    a = "b"

    println("${b.replace("is", "was")} but now is $a")
}


/**
 * 条件表达式
 */

fun maxof(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun max2of(a: Int, b: Int) = if (a > b) a else b

/**
 * 空检测
 */
fun parseInt(a: String): Int? {

    return null
}

/**
 * 自动类型转化
 */
fun getStringLength(objects: Any): Int? {
    if (objects is String) {
        return objects.length
    }

    return null
}

fun sum3(a: Any, b: Any): Int? = if (a is Int && b is Int) a + b else null

/**
 * for循环
 */
fun readList() {
    val list = listOf("a", Byte, 'c', 0)
    for (it in list) {
        println(it)
    }
}

/**
 * while 循环
 */
fun readList2() {
    val list = listOf('c', 1, "a")
    var num = 0
    while (num < list.size) {
        println("第 $num 个元素是${list[num]}")
        num++
    }
}

/**
 * when 表达
 */
fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "2" -> "Two"
        is Long -> "Long"
        else -> "Else"
    }


/**
 * 区间表达式
 */

fun check(num: Int): Boolean {
    val range = 1..10

    return num in range
}

/**
 * 区间迭代
 */
fun readNums() {
    var sum = 0
    for (num in 1..10) {
        sum += num
    }

    println("sum = $sum")
}

/**
 * 区间反转
 */

fun reversed() {
    val range = 1..10 step 2

    for (num in range.reversed()) {
        println("num = $num")
    }
}

/**
 * 区间遍历
 */
fun readListWithIndex() {
    val list = listOf("电脑", "手机", "钱包")
    for ((index, value) in list.withIndex()) {
        println("index = $index 是 $value")
    }
}

/**
 * map
 */
fun readMap() {
    val map = TreeMap<String, String>()
    map["one"] = "1"
    map["two"] = "2"
}

/**
 * 函数模板(lambda)
 */
fun function(x: Int, y: Int) {
    val sum = { a: Int, b: Int -> { a + b } }
    println("sum = ${sum(x, y)}")

    val sum2: (Int, Int) -> Int = { x, y -> x + y }
    println("sum2 = ${sum2(x, y)}")
}

var lambda: (String, String) -> String = { fristName, lastName -> fristName + lastName }

/**
 * 阶乘
 */
fun factorial(a: Int): Int {
    var fsum = 0
    var index = a
    while (index > 0) {
        fsum *= index
        index--
    }

    return fsum
}

/**
 * 尾递归
 *
 * 对于一个递归函数，我们可以添加"tailrec"修饰符修饰函数，用于标志此函数会被递归调用，编译器编译函数时
 * 会优化此函数，防止堆栈溢出
 */
tailrec fun factorialx(a: Int): Int =
    if (a == 1) 1 else a * factorialx(a - 1)


val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double =
    if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

/**
 * 对于一个class，必须用open修饰才能被继承
 */
abstract class parent(name: String) {
    open fun brithday() {

    }

    abstract fun gender()
}

class child(name: String) : parent(name) {
    override fun gender() {
    }

    override fun brithday() {
        super.brithday()
    }
}


/**
 * 接口
 */

interface IHuman {
    var name:String
    var age:Int
    
    fun voice()

    fun work()
}

class man(override var name: String, override var age: Int) : IHuman {
    override fun voice() {
        println("man voice")
    }

    override fun work() {
        println("man work")
    }
}

/**
 * 代理,必须要要代理给一个实例
 */
class woman(override var name: String, override var age: Int) : IHuman by man(name,age) {
    override fun voice() {
        println("woman voice")
    }
}

/**
 * 扩展函数
 */

var world = listOf<IHuman>(man("man",20), 
    man("bigman",30),
    man("smallman",10),
    woman("woman",18))

fun List<IHuman>.checkAge(age:Int){
    filter { it.age>age }.forEach { println("大于此年龄的人叫 ${it.name}") }
}