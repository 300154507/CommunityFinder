/**
 * Created by student on 3/23/15.
 */
package communityfinder.com.communityfinder;
public class Community {
    private int CSDCode;
    private String subDivision;
    private int incomeScore;
    private int educationScore;
    private int housingScore;
    private int labourForceActivityScore;
    private int cwbScore;
    private int population;
    private String category;
    private String province;

    public Community()
    {
        CSDCode = 0;
        subDivision = "";
        incomeScore = 0;
        educationScore = 0;
        housingScore = 0;
        labourForceActivityScore = 0;
        cwbScore = 0;
        population = 0;
        category = "";
        province = "";
    }
    public Community(int csd,String division,int incomeScore,int educationScore,int housingScore,int labourForceActivityScore,int cwbScore,int population,String cat,String pro)
    {
        CSDCode = csd;
        subDivision = division;
        this.incomeScore = incomeScore;
        this.educationScore = educationScore;
        this.housingScore = housingScore;
        this.labourForceActivityScore = labourForceActivityScore;
        this.cwbScore = cwbScore;
        this.population = population;
        category = cat;
        province = pro;
    }
    public int getCSDCode()
    {
        return CSDCode;
    }
    public String getSubDivision()
    {
        return subDivision;
    }
    public int getIncomeScore()
    {
        return incomeScore;
    }
    public int getEducationScore()
    {
        return educationScore;
    }
    public int getHousingScore()
    {
        return housingScore;
    }
    public int getLabourForceActivityScore()
    {
        return labourForceActivityScore;
    }
    public int getCwbScore()
    {
        return cwbScore;
    }
    public int getPopulation()
    {
        return population;
    }
    public String getCategory()
    {
        return category;
    }
    public String getProvince()
    {
        return  province;
    }
    public void setCSDCode(int id)
    {
        CSDCode = id;
    }
    public void setSubDivision(String sub)
    {
        subDivision = sub;
    }
    public void setIncomeScore(int income)
    {
        incomeScore = income;
    }
    public void setEducationScore(int eScore)
    {
        educationScore = eScore;
    }
    public void setHousingScore(int house)
    {
        housingScore = house;
    }
    public void setLabourForceActivityScore(int labour)
    {
        labourForceActivityScore = labour;
    }
    public void setCwbScore(int cwb)
    {
        cwbScore = cwb;
    }
    public void setPopulation(int pop)
    {
        population = pop;
    }
    public void  setCategory(String cat)
    {
        category = cat;
    }
    public void setProvince(String pro)
    {
        province = pro;
    }
    public String toString()
    {
        return CSDCode + "\n"
                + subDivision + " "
                + incomeScore + " "
                + educationScore + " "
                + housingScore + " "
                + labourForceActivityScore + " "
                + cwbScore + " "
                + population + " "
                + category + " "
                + province;
    }
}
