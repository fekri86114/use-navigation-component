package info.fekri.androidcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import info.fekri.androidcomponents.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * ### Get data and set
         * get the data which we sent from MainFragment and set
         * */
        // get data
        val name: String = ResultFragmentArgs.fromBundle(requireArguments()).myName
        val age: Int = ResultFragmentArgs.fromBundle(requireArguments()).myAge
        val email: String = ResultFragmentArgs.fromBundle(requireArguments()).myEmail
        val password: String = ResultFragmentArgs.fromBundle(requireArguments()).myPassword

        // set data
        binding.txtShowName.text     = name
        binding.txtShowAge.text      = age.toString()
        binding.txtShowEmail.text    = email
        binding.txtShowPassword.text = password

        /**
         * ### Back to MainFragment by click-on-btnBack
         * Comeback to MainFragment by clicking on Back button
         * */
        binding.btnBack.setOnClickListener {
            // will add
        }

    }

}