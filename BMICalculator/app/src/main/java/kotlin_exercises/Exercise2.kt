package kotlin_exercises

/**
 * Exercise 2
 * To test your code, you need a generator that can create random employees. Define a class with a fixed list of potential names (inside the class body), and that is
 * configured by a minimum and maximum salary (inside the class header). Once again, the main function demonstrates how you can use this class.
 * Hint
 * Lists have an extension function called .random() that returns a random item within a list.
 * Hint
 * Random.nextInt(from = ..., until = ...) gives you a random Int number within specified limits.
 * 87
 * import kotlin.random.Random
 * data class Employee(val name: String, var salary: Int)
 * // Write your code here
 * fun main() {
 * val empGen = RandomEmployeeGenerator(10, 30)
 * println(empGen.generateEmployee())
 * println(empGen.generateEmployee())
 * println(empGen.generateEmployee())
 * empGen.minSalary = 50
 * empGen.maxSalary = 100
 * println(empGen.generateEmployee())
 * }
 *
 */

import kotlin.random.Random

data class Employee(val name: String, var salary: Int)
class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int) {
    private val names = listOf("John", "Mary", "Ann", "Paul", "Jack", "Elizabeth")
    fun generateEmployee() =
        Employee(names.random(), Random.nextInt(from = minSalary, until = maxSalary))
}

fun main() {
    val empGen = RandomEmployeeGenerator(10, 30)
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    empGen.minSalary = 50
    empGen.maxSalary = 100
    println(empGen.generateEmployee())
}
