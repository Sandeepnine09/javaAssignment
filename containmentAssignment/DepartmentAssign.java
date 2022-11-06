package containmentAssignment;

public class DepartmentAssign {

	private int deptno;
	private String deptname;
	private int deptct;
	private String depthead;

	public DepartmentAssign(int deptno, String deptname, int deptct, String depthead) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.deptct = deptct;
		this.depthead = depthead;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getDeptct() {
		return deptct;
	}

	public void setDeptct(int deptct) {
		this.deptct = deptct;
	}

	public String getDepthead() {
		return depthead;
	}

	public void setDepthead(String depthead) {
		this.depthead = depthead;
	}
	
	@Override
	public String toString() {
		return "[deptno=" + deptno + ", deptname=" + deptname + ", deptct=" + deptct + ", depthead="
				+ depthead + "]";
	}

}
