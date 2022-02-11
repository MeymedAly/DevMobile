package com.example.devmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment{
    //View rootView;
    EditText motPasse,email;
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
                if (email.length()<0 && email.length()>8){
                    email.requestFocus();
                    email.setError("Le mot de passe doit etre sup de 8 et inf de 40 ");
                }
                else if(editemail.matches("[0-9]")){
                    email.requestFocus();
                    email.setError("doit contient");
                }
                else {

                    MainActivity activity = (MainActivity) getActivity();
                    activity.setResultat(editemail);
                    LoginFragment loginFragment = new LoginFragment();
                    FragmentManager fm = getParentFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentContainerView,loginFragment);
                    ft.addToBackStack(null);
                }
                if (motPasse.length()>0 && motPasse.length()<8){
                    MainActivity activity = (MainActivity) getActivity();
                    activity.setResultat(editemail);
                    LoginFragment loginFragment = new LoginFragment();
                    FragmentManager fm = getParentFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentContainerView,loginFragment);
                    ft.addToBackStack(null);
                }
                else {
                    motPasse.requestFocus();
                    motPasse.setError("Le mot de passe doit etre sup de 0 et inf de 8 ");
                }



//                boolean ckeck =  validation(editemail,mot);
//                if (ckeck==true){
//                   // ft.commit();
//                }
//                else {
//
//                }
            }
        });
        return view;
    }

    private void init(View view) {
        email = view.findViewById(R.id.email);
        motPasse = view.findViewById(R.id.motPasse);
        button = view.findViewById(R.id.button);
       // button.setOnClickListener(this);
    }

/*
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button){
            String emaile = email.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("email", emaile);
            FragmentManager fm = getParentFragmentManager();
            FragmentTransaction ft =fm.beginTransaction();
            WelcomeFragment welcomeFragment = new WelcomeFragment();
            welcomeFragment.setArguments(bundle);
            ft.replace(R.id.fragmentContainerView2,welcomeFragment);
            ft.addToBackStack(null);

            // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,welcomeFragment).commit();

            String emaill = email.getText().toString();
            String mot = email.getText().toString();
            boolean check = validation(emaill,mot);
            if (check==true){
                ft.commit();
            }
            else{

            }
        }
    }*/

    private Boolean validation(String emaill, String mot) {
        if (mot.length() < 8 && mot.length() > 40) {
            motPasse.requestFocus();
            motPasse.setError("Le mot de passe doit etre sup de 8 et inf de 40 ");
            return false;
        } else if (mot.matches("[0-9]")){
            motPasse.requestFocus();
            motPasse.setError("Un letre alphabetique et Nombres");
            return false;
        } else {
            return true;
        }
    }
}