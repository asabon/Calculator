package net.asabon.calculator

class Display() {
    private var mMessage : String = ""

    fun setMessage(message: String) {
        mMessage = message
    }

    fun getMessage(): String {
        return mMessage
    }

    fun clear() {
        mMessage = ""
    }
}
