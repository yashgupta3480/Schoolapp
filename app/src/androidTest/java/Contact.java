import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
//Enqiry Form on Frontpage to Enquire the company

public class Contact extends Fragment implements View.OnClickListener {
    EditText username,email,messages;
    String user,em,mess;
    Button submit;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.contact, container, false);
        username= (EditText) view.findViewById(R.id.username);
        email= (EditText) view.findViewById(R.id.email);
        messages= (EditText) view.findViewById(R.id.message);
        submit= (Button) view.findViewById(R.id.submit);
        submit.setOnClickListener(this);
        return  view;
    }


    @Override
    public void onClick(View v) {
        user=username.getText().toString();
        em=email.getText().toString();
        mess=messages.getText().toString();


      //  Toast.makeText(getActivity(),myStringJsonData,Toast.LENGTH_LONG).show();
    }
}
