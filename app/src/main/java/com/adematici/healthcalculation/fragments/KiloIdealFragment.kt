package com.adematici.healthcalculation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adematici.healthcalculation.R
import kotlinx.android.synthetic.main.fragment_bazal_metabolizma_hizi.*
import kotlinx.android.synthetic.main.fragment_kilo_ideal.*
import java.lang.Exception

class KiloIdealFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kilo_ideal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_kiloideal_hesapla.setOnClickListener {

            try {
                if(edit_text_kiloideal_boy.text.isEmpty() && edit_text_kiloideal_kilo.text.isEmpty()){
                    Toast.makeText(this.context,"Lütfen Bütün Alanları Doldurunuz.", Toast.LENGTH_SHORT).show()
                } else {

                    val boy = edit_text_kiloideal_boy.text.toString().toInt()
                    val kilo = edit_text_kiloideal_kilo.text.toString().toInt()

                    if (radioGroupKiloIdeal.checkedRadioButtonId == -1){
                        Toast.makeText(this.context,"Lütfen Cinsiyet Seçiniz", Toast.LENGTH_SHORT).show()
                    } else {
                        var islemSonucu: Double
                        if(radiobutton_kiloideal_erkek.isChecked){
                            islemSonucu = (50 + (2.3* incDonustur(boy)-60)) /2.3
                            val yeni:Double = String.format("%.0f", islemSonucu).toDouble()
                            textViewKiloIdealSonuc.text = "İdeal Kilo: $yeni kg"
                        }
                        if(radiobutton_kiloideal_kadin.isChecked){
                            islemSonucu = (45.5 + (2.3* incDonustur(boy)-60)) /2.3
                            val yeni:Double = String.format("%.0f", islemSonucu).toDouble()
                            textViewKiloIdealSonuc.text = "İdeal Kilo: $yeni. kg"
                        }
                        textViewKiloIdealSonuc.visibility = View.VISIBLE
                    }
                }
            } catch (e: Exception){
                e.printStackTrace()
            }

        } // button_bazal_hesapla
    } // onViewCreated

    fun incDonustur(gelenVeri: Int) : Double{
        var x = gelenVeri.toDouble()
        return x / 2.54
    }

}