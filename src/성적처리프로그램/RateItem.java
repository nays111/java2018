package 성적처리프로그램;

public class RateItem {
	
	// 학생의 성적등급은 출석점수, 중간 및 기말시험 점수,
		// 과제 점수, 퀴즈 점수, 발표 점수, 보고서 점수,
		// 기타 점수를 각각의 반영 비율에 따라 합산한 총점에 의해 결정된다
	private int mid, fin, homeWork, PT, quiz, report, etc, atd,
	rateA1,rateA0,rateB1,rateB0,rateC1,rateC0,rateD,rateF;
	
	public int getMid() {
		return mid;
	}

	public int getRateA1() {
		return rateA1;
	}

	public void setRateA1(int rateA1) {
		this.rateA1 = rateA1;
	}

	public int getRateA0() {
		return rateA0;
	}

	public void setRateA0(int rateA0) {
		this.rateA0 = rateA0;
	}

	public int getRateB1() {
		return rateB1;
	}

	public void setRateB1(int rateB1) {
		this.rateB1 = rateB1;
	}

	public int getRateB0() {
		return rateB0;
	}

	public void setRateB0(int rateB0) {
		this.rateB0 = rateB0;
	}

	public int getRateC1() {
		return rateC1;
	}

	public void setRateC1(int rateC1) {
		this.rateC1 = rateC1;
	}

	public int getRateC0() {
		return rateC0;
	}

	public void setRateC0(int rateC0) {
		this.rateC0 = rateC0;
	}

	public int getRateD() {
		return rateD;
	}

	public void setRateD(int rateD) {
		this.rateD = rateD;
	}

	public int getRateF() {
		return rateF;
	}

	public void setRateF(int rateF) {
		this.rateF = rateF;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public int getHomeWork() {
		return homeWork;
	}

	public void setHomeWork(int homeWork) {
		this.homeWork = homeWork;
	}

	public int getPT() {
		return PT;
	}

	public void setPT(int pT) {
		PT = pT;
	}

	public int getQuiz() {
		return quiz;
	}

	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}

	public int getEtc() {
		return etc;
	}

	public void setEtc(int etc) {
		this.etc = etc;
	}

	public int getAtd() {
		return atd;
	}

	public void setAtd(int atd) {
		this.atd = atd;
	}
	
}
