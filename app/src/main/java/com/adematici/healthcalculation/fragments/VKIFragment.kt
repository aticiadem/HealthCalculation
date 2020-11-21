package com.adematici.healthcalculation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adematici.healthcalculation.R
import kotlinx.android.synthetic.main.fragment_v_k_i.*
import java.lang.Exception

class VKIFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_v_k_i, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_vki_hesapla.setOnClickListener {

            try {

                if(edit_text_vkiBoy.text.isEmpty() && edit_text_vkiBoy.text.isEmpty()){
                    Toast.makeText(this.context,"Lütfen Bütün Alanları Doldurunuz.", Toast.LENGTH_SHORT).show()
                } else {
                    val boy = edit_text_vkiBoy.text.toString().toDouble()
                    val kilo = edit_text_vkiKilo.text.toString().toDouble()

                    if (radioGroupvki.checkedRadioButtonId == -1){
                        Toast.makeText(this.context,"Lütfen Cinsiyet Seçiniz", Toast.LENGTH_SHORT).show()
                    } else {
                        val sonucboy: Double
                        val sonuc: Double
                        sonucboy = ((boy*boy)/10000)
                        sonuc = kilo/sonucboy
                        val yenisonuc = String.format("%.1f",sonuc).toDouble()

                        if (yenisonuc <= 18.4){
                            text_view_vkiSonuc.visibility = View.VISIBLE
                            text_view_vkiSonuc.text = "VKİ = $yenisonuc: Zayıf\n" +
                                    "Uzunluğunuza göre uygun ağırlıkta olmadığınızı, zayıf olduğunuzu gösterir. Zayıflık, bazı hastalıklar için risk oluşturan ve istenmeyen bir durumdur. Boyunuza uygun ağırlığa erişmeniz için yeterli ve dengeli beslenmeli, beslenme alışkanlıklarınızı geliştirmeye özen göstermelisiniz."
                        }
                        if (yenisonuc in 18.5..24.9){
                            text_view_vkiSonuc.visibility = View.VISIBLE
                            text_view_vkiSonuc.text = "VKİ = $yenisonuc: Normal Kilo\n" +
                                    "Uzunluğunuza göre uygun ağırlıkta olduğunuzu gösterir. Yeterli ve dengeli beslenerek ve düzenli fiziksel aktivite yaparak bu ağırlığınızı korumaya özen gösteriniz."
                        }
                        if (yenisonuc in 25.0..29.9){
                            text_view_vkiSonuc.visibility = View.VISIBLE
                            text_view_vkiSonuc.text = "VKİ = $yenisonuc: Fazla Kilolu\n" +
                                    "Boyunuza göre vücut ağırlığınızın fazla olduğunu gösterir. Fazla kilolu olma durumu gerekli önlemler alınmadığı takdirde pek çok hastalık için risk faktörü olan obeziteye (şişmanlık) yol açar."
                        }
                        if (yenisonuc >= 30.0){
                            text_view_vkiSonuc.visibility = View.VISIBLE
                            text_view_vkiSonuc.text = "VKİ = $yenisonuc: Şişman-Obez\n" +
                                    "Boyunuza göre vücut ağırlığınızın fazla olduğunu bir başka deyişle şişman olduğunuzun bir göstergesidir. Şişmanlık, kalp-damar hastalıkları, diyabet, hipertansiyon v.b. kronik hastalıklar için risk faktörüdür. Bir sağlık kuruluşuna başvurarak hekim / diyetisyen kontrolünde zayıflayarak normal ağırlığa inmeniz sağlığınız açısından çok önemlidir. Lütfen, sağlık kuruluşuna başvurunuz."
                        }
                    }

                }

            } catch (e:Exception){
                e.printStackTrace()
            }

        }

    }

}