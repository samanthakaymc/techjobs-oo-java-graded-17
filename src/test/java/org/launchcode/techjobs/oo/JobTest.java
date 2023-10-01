package org.launchcode.techjobs.oo;
// import org.testng.annotations.Test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobTest.getName() instanceof String);
        assertTrue(jobTest.getEmployer() instanceof Employer);
        assertTrue(jobTest.getLocation() instanceof Location);
        assertTrue(jobTest.getPositionType() instanceof PositionType);
        assertTrue(jobTest.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(jobTest.getName(), "Product tester");
        assertEquals(jobTest.getEmployer().getValue(), "ACME");
        assertEquals(jobTest.getLocation().getValue(), "Desert");
        assertEquals(jobTest.getPositionType().getValue(), "Quality control");
        assertEquals(jobTest.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job jobTestOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTestTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobTestOne.equals(jobTestTwo));
        }

        @Test
        public void testToStringStartsAndEndsWithNewLine() {
        Job testToString = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobInfo = testToString.toString();
        assertEquals('\n', jobInfo.charAt(0));
        assertEquals('\n', jobInfo.charAt(jobInfo.length()-1));
        };

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testLabels = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String lablesAndData = testLabels.toString();
        assertTrue(lablesAndData.contains("ID: " + testLabels.getId() + '\n'));
        assertTrue(lablesAndData.contains("Name: " + testLabels.getName() + '\n'));
        assertTrue(lablesAndData.contains("Employer: " + testLabels.getEmployer() + '\n'));
        assertTrue(lablesAndData.contains("Location: " + testLabels.getLocation() + '\n'));
        assertTrue(lablesAndData.contains("Position Type: " + testLabels.getPositionType() + '\n'));
        assertTrue(lablesAndData.contains("Core Competency: " + testLabels.getCoreCompetency() + '\n'));
    }

   @Test
    public void testToStringHandlesEmptyField(){
       Job testEmptyFields = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       String lablesAndData = testEmptyFields.toString();
       assertTrue(lablesAndData.contains("Employer: Data not available"));
    }
}

