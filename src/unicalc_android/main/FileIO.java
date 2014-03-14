package unicalc_android.main;

import android.content.Context;
import java.io.*;

public class FileIO {

    private Context mContext;

    public FileIO(Context c) {
        mContext = c;
    }

    public String read(String fileName) throws IOException {

        String ret = "";
        InputStream inputStream = mContext.openFileInput(fileName);

        if ( inputStream != null ) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
            }

            inputStream.close();
            ret = stringBuilder.toString();
        }


        return ret;
    }

    public void write(String fileName, String data) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(mContext.openFileOutput(fileName, Context.MODE_PRIVATE));
        outputStreamWriter.write(data);
        outputStreamWriter.close();
    }
}
