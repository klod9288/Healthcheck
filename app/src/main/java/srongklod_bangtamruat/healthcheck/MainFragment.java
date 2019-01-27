package srongklod_bangtamruat.healthcheck;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;


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



                    try {

                        GetUserWhereUserThead getUserWhereUserThead = new GetUserWhereUserThead(getActivity());
                        MyConstant myConstant = new MyConstant();

                        getUserWhereUserThead.execute(user, myConstant.getUrlGetUserWhereUser());
                        String json = getUserWhereUserThead.get();

                        Log.d("27JanV1", "json ==> " + json);

                        if (json.equals("null")) {
//                            User False
                            myAlert.nomalDialog("User False", "NO " + user + " in my Database");

                        } else {

                            JSONArray jsonArray = new JSONArray(json);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
//
                            if (password.equals(jsonObject.getString("Password"))) {
//                                Password True
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.contentMainFragment, new ServiceFragment()).commit();

                            } else {
//                               Password False
                                myAlert.nomalDialog("Password False", "Please Try Again  Password False");

                            }

                        }


                    } catch (Exception e) {
                    e.printStackTrace();


                    }

                }//if

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
