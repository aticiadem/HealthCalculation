package com.adematici.healthcalculation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adematici.healthcalculation.R
import kotlinx.android.synthetic.main.fragment_bazal_metabolizma_hizi.*
import java.lang.Exception

class BazalMetabolizmaHiziFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bazal_metabolizma_hizi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_bazal_hesapla.setOnClickListener {

            try {
                if(edit_text_bazal_yas.text.isEmpty() && edit_text_bazal_boy.text.isEmpty() && edit_text_bazal_kilo.text.isEmpty()){
                    Toast.makeText(this.context,"Lütfen Bütün Alanları Doldurunuz.",Toast.LENGTH_SHORT).show()
                } else {

                    val yas = edit_text_bazal_yas.text.toString().toInt()
                    val boy = edit_text_bazal_boy.text.toString().toInt()
                    val kilo = edit_text_bazal_kilo.text.toString().toInt()

                    if (radioGroupBazal.checkedRadioButtonId == -1){
                        Toast.makeText(this.context,"Lütfen Cinsiyet Seçiniz",Toast.LENGTH_SHORT).show()
                    } else {
                        var islemSonucu: Double
                        if(radiobutton_bazal_erkek.isChecked){
                            islemSonucu = 66.5 + (13.75*kilo) + (5.03*boy) - (6.75*yas)
                            textViewBazalSonuc.text = "Bazal Metabolik Hız: $islemSonucu kcal/gün"
                        }
                        if(radiobutton_bazal_kadin.isChecked){
                            islemSonucu = 655.1 + (9.56*kilo) + (1.85*boy) - (4.68*yas)
                            textViewBazalSonuc.text = "Bazal Metabolik Hız: $islemSonucu kcal/gün"
                        }
                        textViewBazalSonuc.visibility = View.VISIBLE
                    }
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        } // button_bazal_hesapla
    } // onViewCreated


}