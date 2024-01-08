package net.asabon.calculator

class Number() {

    private var mNumber : String = ""
    private var mHasDot : Boolean = false

    fun putKey(key: String) : String {
        if (key == ".") {
            if (mHasDot) {
                /* "." は 1 個しか持てないのですでにあったら受け付けない */
                return mNumber
            } else {
                mHasDot = true
            }
        }
        mNumber += key
        return mNumber
    }

    fun setNumber(num: String) {
        mNumber = num
        val idx = mNumber.indexOf(".")
        mHasDot = idx != -1
    }

    fun getNumber() : String {
        return mNumber
    }

    fun clear() : String {
        mNumber = ""
        mHasDot = false
        return mNumber
    }
}
