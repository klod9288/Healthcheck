package srongklod_bangtamruat.healthcheck;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Content

        registerContent();

//        LoginController
        loginController();

    }//Main Method

    private void loginController() {

        Button button = getActivity().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                String user = userEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();


                MyAlert myAlert = new MyAlert(getActivity());
                if (user.isEmpty() || password.isEmpty()) {
//                    Have Space
                    myAlert.nomalDialog("Have Space", "Please fill Every Blank");
                } else {
//                    NO Space

                }

            }
        });

    }


    private void registerContent() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment()).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}
