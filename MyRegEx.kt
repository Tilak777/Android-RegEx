import java.util.regex.Pattern

object MyRegEx {
    internal const val MULTIPLE_SPACE = "^(?!.* {2}).+"
    internal const val FRONT_BACK_SPACE = "^[^\\s]+(\\s+[^\\s]+)*\$"
    internal const val HAS_SYMBOLS = "(^(?!.* {2}).*)([a-zA-Z0-9]*[ ]*[^a-zA-Z0-9 ]+)([a-zA-Z0-9]*[^a-zA-Z0-9 ])*(?:([a-zA-Z0-9]*[^a-zA-Z0-9]*)([a-zA-Z0-9]*[^a-zA-Z0-9]*)*)*"
    internal const val HAS_NUMBERS = "^([^0-9]*)\$"
    internal const val FIRST_NAME_CAPITAL = "^[A-Z][a-z]*(?: [a-zA-Z]*)*\$"
    internal const val FIRST_NAME_SIZE = "^[A-Z][a-z]{2,}(?: [a-zA-Z]*)*\$"
    internal const val FULL_NAME = "^[A-Z][a-z]{2,}(?: [A-Z][a-z]*)+\$"
    
    internal const val FULL_NAME_MAX5 = "^[A-Z][a-z]{2,}(?: [A-Z][a-z]*){0,4}$"
}

fun MyRegEx.checkFullNameValidation(fName:String):String? {

    return when {
        fName.isEmpty()
        -> "Full name can not be empty."

        !Pattern.matches(MULTIPLE_SPACE, fName)
        -> "Name should not contain multiple spaces."

        !Pattern.matches(FRONT_BACK_SPACE, fName)
        -> "Name should not start or end with blank space."

        !Pattern.matches(HAS_NUMBERS, fName)
        -> "Name should not contain number."

        Pattern.matches(HAS_SYMBOLS, fName)
        -> "Name should not contain symbols."

        !Pattern.matches(FIRST_NAME_CAPITAL, fName)
        -> "First Name should start with capital letter."

        !Pattern.matches(FIRST_NAME_SIZE, fName)
        -> "First Name should be minimum 3 letters."

//         !Pattern.matches(FULL_NAME, fName)
        !Pattern.matches(FULL_NAME_MAX5, fName)
        -> "Full Name must be like eg. ' First Middle Last '"

        else -> null
    }
}
