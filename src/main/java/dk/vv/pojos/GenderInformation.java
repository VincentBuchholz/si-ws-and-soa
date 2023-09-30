package dk.vv.pojos;

public class GenderInformation {

    private String gender;

    public GenderInformation() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "GenderInformation{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
