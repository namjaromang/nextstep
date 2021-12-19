package baseball.computer;

public interface IComputer {

  /**
   * 처음 지정된 자릿수 셋팅하는 함수
   */
  public void initialize();

  /**
   * user가 입력한 값 확인 및 결과 값 출력 함수
   */
  public boolean checkAndPrint(Integer[] b);

}
