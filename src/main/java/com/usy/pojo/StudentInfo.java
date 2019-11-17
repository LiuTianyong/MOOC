package com.usy.pojo;

public class StudentInfo {

    //账号（学号）
	private String schoolNum;
    //密码
	private String password;
    //学生姓名
	private String stuName;


	public String getSchoolNum() {
		return schoolNum;
	}

	public void setSchoolNum(String schoolNum) {
		this.schoolNum = schoolNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInfo other = (StudentInfo) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (schoolNum == null) {
			if (other.schoolNum != null)
				return false;
		} else if (!schoolNum.equals(other.schoolNum))
			return false;
		if (stuName == null) {
			if (other.stuName != null)
				return false;
		} else if (!stuName.equals(other.stuName))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "StudentInfo{" +
                "schoolNum='" + schoolNum + '\'' +
                ", password='" + password + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
