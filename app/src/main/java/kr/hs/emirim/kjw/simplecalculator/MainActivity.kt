package kr.hs.emirim.kjw.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText;
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button;
    lateinit var btnMin : Button;
    lateinit var btnMul : Button;
    lateinit var btnDiv : Button;
    lateinit var btnMod : Button;
    lateinit var textResult : TextView
    lateinit var num1 : String;
    lateinit var num2 : String;
    var result : Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)
        textResult = findViewById(R.id.text_result)
        btnAdd = findViewById(R.id.btn_plus)
        btnMin = findViewById(R.id.btn_minus)
        btnMul = findViewById(R.id.btn_multiply)
        btnDiv = findViewById(R.id.btn_dvide)
        btnMod = findViewById(R.id.btn_mod)
        btnAdd.setOnClickListener(btnListener)
        btnMin.setOnClickListener(btnListener)
        btnMul.setOnClickListener(btnListener)
        btnDiv.setOnClickListener(btnListener)
        btnMod.setOnClickListener(btnListener)

    }
    var btnListener = OnClickListener {
        num1 = edit1.text.toString()
        num2 = edit2.text.toString()
        if (num1 == "" || num2 == "") {
            Toast.makeText(baseContext, "숫자를 입력하지 않고 버튼을 누르면 안됨!", Toast.LENGTH_LONG).show()
            return@OnClickListener
        }

        when(it.id){
            R.id.btn_plus -> result = num1.toDouble() + num2.toDouble()
            R.id.btn_minus -> result = num1.toDouble() - num2.toDouble()
            R.id.btn_multiply -> result = num1.toDouble() * num2.toDouble()
            R.id.btn_dvide -> {
                if (num2.toDouble() == 0.0) {
                    Toast.makeText(baseContext, "0으로 나누면 안됨!!", Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1.toDouble() / num2.toDouble()
            }
            R.id.btn_mod -> result = num1.toDouble() % num2.toDouble()
        }
        textResult.text = "계산 결과: " + result
    }
}