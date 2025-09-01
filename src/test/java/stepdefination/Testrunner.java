package stepdefination;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\sarit\\git\\myown\\myown\\Aug2nd2025\\src\\test\\resources\\Features"
,glue= {"com.oranghrm.stepdefinitions"}
,dryRun=false
,monochrome=true)
 
 
public class Testrunner {

 
}