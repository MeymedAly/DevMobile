package com.example.devmobile;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.support.v4.media.MediaMetadataCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment{
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText motPasse,email;
    static String constWelcom ="Bienvenue";
    public static String mymed ="meymed.aly@gmail.com";
    public static String psw ="11111aaaaB";
    Button button;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        init(view);

        //return rootView;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editemail = email.getText().toString();
                String mot = motPasse.getText().toString();
                MainActivity activity = (MainActivity) getActivity();
                String welcom = constWelcom.toString();

//                LoginFragment loginFragment = new LoginFragment();
//                FragmentManager fm = getParentFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.fragmentContainerView,loginFragment);
//                ft.addToBackStack(null);
               boolean check = validation(editemail,mot);
               //if (check = true){
                   if (editemail== mymed && mot== psw) {
                        activity.setResultat(editemail, welcom);
                    }
              //}
              // else {
                  // Toast.makeText(getActivity(), "les donnes ne sont pas envoyer", Toast.LENGTH_SHORT).show();
              // }
            }
        });
        return view;
    }

    private void init(View view) {
        email = view.findViewById(R.id.email);
        motPasse = view.findViewById(R.id.motPasse);
        button = view.findViewById(R.id.button);
       // constWelcom = view.toString();
       // button.setOnClickListener(this);
    }


    private Boolean validation(String emaill, String mot) {
        if (emaill.length()==0) {
            email.requestFocus();
            email.setError("Entrer un email S.V.P ");
            return false;
        }
        else if (emaill.matches(emailPattern)){
           // ^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$
            email.requestFocus();
            email.setError("Entrer valide email ");
            return false;
        }
        else if (mot.length()==0){
            motPasse.requestFocus();
            motPasse.setError("Entrer un mot de passe S.V.P");
            return false;
        }
        else if (!(mot.length() >8)){
            motPasse.requestFocus();
            motPasse.setError("Entrer un mot de passe sup 8 S.V.P");
            return false;
        }
        else if (!(mot.length() <40)){
            motPasse.requestFocus();
            motPasse.setError("Entrer un mot de passe inf 40 S.V.P");
            return false;
        }
        else if (mot.matches("[^0-9]+")){
            motPasse.requestFocus();
            motPasse.setError("au moins un chiffre");
            return false;
        }
        else if (mot.matches("[^a-z]+")){
            motPasse.requestFocus();
            motPasse.setError("au moins un lettre miniscule");
            return false;
        }
        else if (mot.matches("[^A-Z]+")){
            motPasse.requestFocus();
            motPasse.setError("au moins un lettre majescule");
            return false;
        }
        else if (mot.matches("[^(?=%#!/|`~.*[_@,;.()]).*$]+")){
            motPasse.requestFocus();
            motPasse.setError("au moins un symbole");
            return false;
        }
        else {
            return true;
        }
    }
}