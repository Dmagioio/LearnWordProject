package com.example.myapplication

data class Word(
    val original: String,
    val translate: String,
    var learned: Boolean = false,
)

data class Question(
    val variants: List<Word>,
    val correctAnswer: Word,
)

class LearnWordsTrainer {

    private val dictionary = listOf(
        Word(original = "Alien", translate = "Інопланетянин"),
        Word(original = "Fish", translate = "Риба"),
        Word(original = "Drink", translate = "Напій"),
        Word(original = "Engine", translate = "Двигун"),
        Word(original = "Color", translate = "Колір"),
        Word(original = "Planet", translate = "Планета"),
        Word(original = "Magic", translate = "Магія"),
        Word(original = "Space Travel", translate = "Космічна подорож"),
        Word(original = "Book", translate = "Книга"),
        Word(original = "Ship", translate = "Корабель"),
        Word(original = "Towel", translate = "Рушник"),
        Word(original = "Robot", translate = "Робот"),
        Word(original = "Drink Mix", translate = "Коктейль"),
        Word(original = "Smart", translate = "Розумний"),
        Word(original = "Teleport", translate = "Телепорт"),
        Word(original = "Mind", translate = "Розум"),
        Word(original = "Universe", translate = "Всесвіт"),
        Word(original = "Traveler", translate = "Мандрівник"),
        Word(original = "Whale", translate = "Кит"),
        Word(original = "Flower", translate = "Квітка"),
        Word(original = "Heart", translate = "Серце"),
        Word(original = "Galaxy", translate = "Галактика"),
        Word(original = "End", translate = "Кінець"),
        Word(original = "Space", translate = "Космос"),
        Word(original = "Chance", translate = "Ймовірність"),
        )

    private var currentQuestion: Question? = null

    fun getNextQuestion(): Question? {

        val notLearnedList = dictionary.filter { !it.learned }
        if (notLearnedList.isEmpty()) return null

        val questionWords =
            if (notLearnedList.size < NUMBER_OF_ANSWERS) {
                val learnedList = dictionary.filter { it.learned }.shuffled()
                notLearnedList.shuffled()
                    .take(NUMBER_OF_ANSWERS) + learnedList
                    .take(NUMBER_OF_ANSWERS - notLearnedList.size)
            } else {
                notLearnedList.shuffled().take(NUMBER_OF_ANSWERS)
            }.shuffled()

        val correctAnswer: Word = questionWords.random()

        currentQuestion = Question(
            variants = questionWords,
            correctAnswer = correctAnswer,
        )

        return currentQuestion
    }

    fun checkAnswer(userAnswerIndex: Int): Boolean {

        return currentQuestion?.let {
            val correctAnswerId = it.variants.indexOf(it.correctAnswer)
            if (correctAnswerId == userAnswerIndex) {
                it.correctAnswer.learned = true
                true
            } else {
                false
            }
        } ?: false
    }

    companion object {
        const val NUMBER_OF_ANSWERS: Int = 4
    }
}
