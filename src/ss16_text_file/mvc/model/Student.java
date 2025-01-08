package ss16_text_file.mvc.model;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String major;

    public Student(int id, String name, String dob, String major) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String toCSV() {
        return id + "," + name + "," + dob + "," + major;
    }

    @Override
    public String toString() {
        return "SV {" +
                "Mã SV = " + id +
                ", Tên = '" + name + '\'' +
                ", Ngày/Tháng/Năm = '" + dob + '\'' +
                ", Chuyên ngành = '" + major + '\'' +
                '}';
    }

    public static Student fromCSV(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            return null;
        }

        String[] parts = csvLine.split(",");

        if (parts.length < 4) {
            return null;
        }

        try {
            return new Student(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    parts[3]
            );
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng dữ liệu: " + e.getMessage());
            return null;
        }
    }
}

