/**
 * Represents a student and its associated data
 *
 * @author Bhavyai Gupta
 */
public class Student implements Comparable<Student> {
    private String number;
    private String lastName;
    private String homeDepartment;
    private String program;
    private int year;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeDepartment() {
        return homeDepartment;
    }

    public void setHomeDepartment(String homeDepartment) {
        this.homeDepartment = homeDepartment;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Student o) {
        return this.lastName.toLowerCase().compareTo(o.lastName.toLowerCase());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("| %10s |", this.number));
        sb.append(String.format(" %-25s |", this.lastName));
        sb.append(String.format(" %10s |", this.homeDepartment));
        sb.append(String.format(" %7s |", this.program));
        sb.append(String.format(" %4s |%n", this.year));

        return sb.toString();
    }

    /**
     * Returns header row for Student records
     *
     * @return header row
     */
    public static String studentHeader() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("| %10s |", "Student No"));
        sb.append(String.format(" %-25s |", "Last Name"));
        sb.append(String.format(" %10s |", "Department"));
        sb.append(String.format(" %7s |", "Program"));
        sb.append(String.format(" %4s |%n", "Year"));

        return sb.toString();
    }

    /**
     * Returns divider row for Student records
     *
     * @return divider row
     */
    public static String studentDivider() {
        StringBuilder divider = new StringBuilder();
        String header = Student.studentHeader();

        for(int i=0; i<header.length(); i++) {
            if(header.charAt(i) == '|') {
                divider.append('+');
            }

            else if(header.charAt(i) == '\r' || header.charAt(i) == '\n') {
                continue;
            }

            else {
                divider.append('-');
            }
        }

        divider.append(String.format("%n"));
        return divider.toString();
    }
}
