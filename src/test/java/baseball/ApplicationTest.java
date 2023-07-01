package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
            () -> {
                run("246", "135", "1", "597", "589", "2");
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
            },
            1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 모든_경우의_수() {
        assertRandomNumberInRangeTest(
            () -> {
                run("456",
                    "416", "412", "312",
                    "136", "132",
                    "145", "124", "123",
                    "2"
                );
                assertThat(output()).contains(
                    "낫싱",
                    "1볼", "2볼", "3볼",
                    "1볼 1스트라이크", "2볼 1스트라이크",
                    "1스트라이크", "2스트라이크", "3스트라이크",
                    "게임 종료");
            },
            1, 2, 3
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("023"))
                .isInstanceOf(IllegalArgumentException.class)
        );

        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("112"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
