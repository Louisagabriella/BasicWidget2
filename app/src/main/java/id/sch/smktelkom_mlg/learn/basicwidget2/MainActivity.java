package id.sch.smktelkom_mlg.learn.basicwidget2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOk.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       doProcess();
                                   }
                               }
        );
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());
            int usia = 2016 - tahun;
            tvHasil.setText(nama + " berusia " + usia + " tahun");
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Kelahiran belum diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Format Tahun Kelahiran bukan yyyy");
            valid = false;
        } else {
            etTahun.setError(null);
        }

        return valid;
    }
}
