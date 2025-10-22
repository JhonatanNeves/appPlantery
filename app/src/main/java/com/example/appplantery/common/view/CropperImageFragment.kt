package com.example.appplantery.common.view

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.canhub.cropper.CropImageView
import com.example.appplantery.R
import com.example.appplantery.databinding.FragmentImageCropperBinding

class CropperImageFragment : Fragment(R.layout.fragment_image_cropper) {

    private var binding: FragmentImageCropperBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentImageCropperBinding.bind(view)

        // Pega a URI da imagem original passada como argumento
        val uriToCrop = arguments?.getParcelable<Uri>(KEY_URI)

        if (uriToCrop == null) {
            // Se a URI for nula, não há nada a fazer, então volte.
            parentFragmentManager.popBackStack()
            return
        }

        binding?.let {
            // Configura a CropImageView
            with(it.cropperContainer) {
                setAspectRatio(1, 1)
                setFixedAspectRatio(true)

                // Carrega a imagem a ser cortada
                setImageUriAsync(uriToCrop)

                // Define o listener que será chamado APÓS a imagem ser salva com sucesso
                setOnCropImageCompleteListener { view, result ->
                    if (result.isSuccessful) {
                        // Pega a URI da imagem salva
                        val croppedUri = result.uriContent

                        // Envia a URI de volta para o fragment anterior
                        setFragmentResult("cropKey", bundleOf(KEY_URI to croppedUri))

                        // Volta para a tela anterior
                        parentFragmentManager.popBackStack()
                    }
                    // Se houver erro, você pode tratar aqui (result.error)
                }
            }

            // Configura o botão Cancelar
            it.cropperBtnCancel.setOnClickListener {
                parentFragmentManager.popBackStack()
            }

            // Configura o botão Salvar
            it.cropperBtnSave.setOnClickListener {
                // Inicia a operação de corte de forma assíncrona.
                // O resultado será entregue no listener `setOnCropImageCompleteListener`
                binding?.cropperContainer?.croppedImageAsync()
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    companion object {
        const val KEY_URI = "key_uri"
    }
}
