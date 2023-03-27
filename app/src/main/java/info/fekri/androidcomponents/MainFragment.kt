package info.fekri.androidcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import info.fekri.androidcomponents.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGo.setOnClickListener {
            /**
             * ### send data by safeargs
             *
             * get data and check if it's null or not-null
             *
             * if data is null, show error
             * */
            val name = binding.edtName.text.toString()
            val age = binding.edtAge.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            if (name.isNotEmpty() && age.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty())
            // Send data by safeargs
                findNavController()
                    .navigate(
                        MainFragmentDirections
                            .actionMainFragmentToResultFragment2()
                            .setMyName(name)
                            .setMyAge(age.toInt())
                            .setMyEmail(email)
                            .setMyPassword(password)
                    )
            else {
                binding.edtName.error = "Enter your name"
                binding.edtAge.error = "Enter your age"
            }
        }

    }

}