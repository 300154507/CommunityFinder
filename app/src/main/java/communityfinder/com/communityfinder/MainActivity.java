package communityfinder.com.communityfinder;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    TextView CSDId;
    EditText Subdivision;
    EditText IncomeScore;
    EditText Education;
    EditText Housing;
    EditText LabourForce;
    EditText CWB;
    EditText Population;
    EditText Category;
    EditText Province;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      final CommunityDBHandler dbHandler = new CommunityDBHandler(this,null,null,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button foo = (Button) findViewById(R.id.button);


        CSDId = (TextView)findViewById(R.id.editText);
        Subdivision = (EditText)findViewById(R.id.editText2);
        IncomeScore = (EditText)findViewById(R.id.editText3);
        Education = (EditText)findViewById(R.id.editText4);
        Housing = (EditText)findViewById(R.id.editText5);
        LabourForce = (EditText)findViewById(R.id.editText6);
        CWB = (EditText)findViewById(R.id.editText7);
        Population = (EditText)findViewById(R.id.editText8);
        Category = (EditText)findViewById(R.id.editText9);
        Province = (EditText)findViewById(R.id.editText10);

        foo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int csd = Integer.parseInt(CSDId.getText().toString());
                String subDivision =  Subdivision.getText().toString();
                String cate = Category.getText().toString();
                String pro = Province.getText().toString();
                int incScore = Integer.parseInt(IncomeScore.getText().toString());
                int edScore = Integer.parseInt(Education.getText().toString());
                int housing = Integer.parseInt(Housing.getText().toString());
                int labour = Integer.parseInt(LabourForce.getText().toString());
                int cwb = Integer.parseInt(CWB.getText().toString());
                int population = Integer.parseInt(Population.getText().toString());

                Community com = new Community(csd,subDivision,incScore,edScore,housing,labour,cwb,population,cate,pro);
                dbHandler.addCommunity(com);

                Subdivision.setText("");
                IncomeScore.setText("");
                Education.setText("");
                Housing.setText("");
                LabourForce.setText("");
                CWB.setText("");
                Population.setText("");
                Category.setText("");
                Province.setText("");



            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_about,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void findCommunity(View view)
    {
        CommunityDBHandler dbHandler = new CommunityDBHandler(this,null,null,1);
        Community community = dbHandler.findCommunity(Integer.parseInt(CSDId.getText().toString()));
        if(community != null)
        {
            CSDId.setText(String.valueOf(community.getCSDCode()));
            Subdivision.setText(community.getSubDivision());
            IncomeScore.setText(String.valueOf(community.getIncomeScore()));
            Education.setText(String.valueOf(community.getEducationScore()));
            Housing.setText(String.valueOf(community.getHousingScore()));
            LabourForce.setText(String.valueOf(community.getLabourForceActivityScore()));
            CWB.setText(String.valueOf(community.getCwbScore()));
            Population.setText(String.valueOf(community.getPopulation()));
            Category.setText(community.getCategory());
            Province.setText(community.getProvince());
        }
    }
    public void deleteCommunity(View view)
    {
        CommunityDBHandler dbHandler = new CommunityDBHandler(this,null,null,1);
        boolean result = dbHandler.deleteCommunity(Integer.parseInt(CSDId.getText().toString()));

        if(result)
        {
            CSDId.setText("");
            Subdivision.setText("");
            IncomeScore.setText("");
            Education.setText("");
            Housing.setText("");
            LabourForce.setText("");
            CWB.setText("");
            Population.setText("");
            Category.setText("");
            Province.setText("");
        }


    }
    public void displayAllRecords(View view)
    {
        CommunityDBHandler dbHandler = new CommunityDBHandler(this,null ,null,1);
        ArrayList<Community> goo = dbHandler.getAllCommuntites();
        String str = "";
        for(int x = 0; x < goo.size();x++)
        {
            Community cool = goo.get(x);
            str += cool;
            str += "\n";

        }
        Intent intent = new Intent(this,CommunityQuery.class);
        intent.putExtra("1",str);
        startActivity(intent);
    }
    public void displayRecordByCategory(View view)
    {
        CommunityDBHandler dbHandler = new CommunityDBHandler(this,null ,null,1);

        ArrayList<Community> goo = dbHandler.findCommunityByCategory("");
        String str = "";
        for(int x = 0; x < goo.size();x++)
        {
            Community cool = goo.get(x);
            str += cool;
            str += "\n";

        }
        Intent intent = new Intent(this,CommunityQuery.class);
        intent.putExtra("1",str);
        startActivity(intent);
    }
    public void clickAbout(MenuItem item)
    {
        startActivity(new Intent(this,About.class));

    }
    public void clickHelp(MenuItem item)
    {
        startActivity(new Intent(this,Help.class));
    }


}
