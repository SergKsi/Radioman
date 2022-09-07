import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;

public class RadioTest {
    // -----------------------------
    // ТЕСТЫ - РАДИОСТАНЦИЯ - НАЧАЛО
    // -----------------------------

    // проверяем, что радиостанции можно установить станцию
    @Test
    public void shouldSetRadioStation() {
        Radio rd = new Radio();
        rd.setCurrentRadioStation(8); // установить радиостанцию
        int expected = 8;
        int actual = rd.getCurrentRadioStation(); // запросить радиостанцию
        Assertions.assertEquals(expected, actual);
    }

    // проверяем, что радиостанции можно установить МАКС. станцию
    @Test
    public void shouldToMaxRadioStation() {
        Radio rd = new Radio();
        rd.setToMaxRadioStation(); // запроисли МАХ станцию
        int expected = 9;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // проверяем, что радиостанции можно установить МИН. станцию
    @Test
    public void shoulToMinRadioStation() {
        Radio rd = new Radio();
        rd.setToMinRadioStation(); // запроисли МИН станцию
        int expected = 0;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // проверяем, если установили ВЫШЕ МАКСимальной радиостанции
    // - НЕ допустимо все, что не попадает в интервал от 0 до 9
    @Test
    public void shouldNotSetMaxRadioStatio() {
        Radio rd = new Radio();
        rd.setCurrentRadioStation(14);
        int expected = 9;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // проверяем, если установили НИЖЕ МИНимальной радиостанции
    // - НЕ допустимо все, что не попадает в интервал от 0 до 9
    @Test
    public void shouldNotSetMinRadioStatio() {
        Radio rd = new Radio();
        rd.setCurrentRadioStation(-7);
        int expected = 9;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // следующая станцимя в диапазоне от 0 до 8
    @Test
    public void shouldSetNextRadioStation08() {
        Radio rd = new Radio();
        rd.nextRadioStation(5);
        int expected = 6;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // следующая станцимя = 9 - переходим на станциюю = 0
    @Test
    public void shouldSetNextRadioStation9() {
        Radio rd = new Radio();
        rd.nextRadioStation(9);
        int expected = 0;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // предыдущая станцимя в диапазоне от 1 до 9
    @Test
    public void shouldSetPrevRadioStation19() {
        Radio rd = new Radio();
        rd.prevRadioStation(9);
        int expected = 8;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // следующая станцимя = 9 - переходим на станциюю = 0
    @Test
    public void shouldSetPrevRadioStation0() {
        Radio rd = new Radio();
        rd.prevRadioStation(0);
        int expected = 9;
        int actual = rd.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }


    // ТЕСТЫ С КОНСТРУКТОРОМ


    // следующая станцимя в диапазоне от 0 до 8
    @Test
    public void shouldSetNextRadioStationConstr08() {
        Radio rd = new Radio(10);
        rd.nextRadioStation(7);
        Assertions.assertEquals(8, rd.getCurrentRadioStation());
    }

    // следующая станцимя = 9 - переходим на станциюю = 0
    @Test
    public void shouldSetNextRadioStationConstr9() {
        Radio rd = new Radio(10);
        rd.nextRadioStation(9);
        Assertions.assertEquals(0, rd.getCurrentRadioStation());
    }

    // кол-во станций = 300,за 299 - 0
    @Test
    public void shouldSetNextRadioStationConstr300299() {
        Radio rd = new Radio(300);
        rd.nextRadioStation(299);
        Assertions.assertEquals(0, rd.getCurrentRadioStation());
    }

    // кол-во станций = 300,за 291 - 292
    @Test
    public void shouldSetNextRadioStationConstr300291() {
        Radio rd = new Radio(300);
        rd.nextRadioStation(291);
        Assertions.assertEquals(292, rd.getCurrentRadioStation());
    }

    // кол-во станций = 300,за 0 - 1
    @Test
    public void shouldSetNextRadioStationConstr3000() {
        Radio rd = new Radio(300);
        rd.nextRadioStation(0);
        Assertions.assertEquals(1, rd.getCurrentRadioStation());
    }

    // предыдущая станцимя в диапазоне от 1 до 9
    @Test
    public void shouldSetPrevRadioStationConstr19() {
        Radio rd = new Radio(10);
        rd.prevRadioStation(8);
        Assertions.assertEquals(7,rd.getCurrentRadioStation());
    }

    // следующая станцимя = 9 - переходим на станциюю = 0
    @Test
    public void shouldSetPrevRadioStationConstr0() {
        Radio rd = new Radio(10);
        rd.prevRadioStation(0);
        Assertions.assertEquals(9,rd.getCurrentRadioStation());
    }

    // кол-во станций = 300,перед 299 - 298
    @Test
    public void shouldSetPrevRadioStationConstr300299() {
        Radio rd = new Radio(300);
        rd.prevRadioStation(299);
        Assertions.assertEquals(298,rd.getCurrentRadioStation());
    }

    // кол-во станций = 300,перед 0 - 299
    @Test
    public void shouldSetPrevRadioStationConstr3000() {
        Radio rd = new Radio(300);
        rd.prevRadioStation(0);
        Assertions.assertEquals(299,rd.getCurrentRadioStation());
    }

    // кол-во станций = 300,перед 156 - 155
    @Test
    public void shouldSetPrevRadioStationConstr300156() {
        Radio rd = new Radio(300);
        rd.prevRadioStation(156);
        Assertions.assertEquals(155,rd.getCurrentRadioStation());
    }

    // -----------------------------
    // ТЕСТЫ - РАДИОСТАНЦИЯ - КОНЕЦ
    // -----------------------------

    // -----------------------------
    // ТЕСТЫ - Громкость звука - НАЧАЛО
    // -----------------------------

    //Клиент должен иметь возможность увеличивать и уменьшать
    // уровень громкости звука (в пределах от 0 до 10)
    @Test
    public void shouldSetVolume() {
        Radio rd = new Radio();
        rd.setCurrentVolumeRadioStation(5);
        int expected = 5;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // проверяем, что громкость = МАКС.
    @Test
    public void shouldSetMaxVolume() {
        Radio rd = new Radio();
        rd.setToMaxVolume();
        int expected = 100;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // проверяем, что громкость = МИН.
    @Test
    public void shouldSetMinVolume() {
        Radio rd = new Radio();
        rd.setToMinVolume();
        int expected = 0;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // проверяем, если установили ВЫШЕ МАКСимальной громкости - устанавливаем максимальную = 10
    // - НЕ допустимо все, что не попадает в интервал от 0 до 10
    @Test
    public void shouldNotSetMaxVolume() {
        Radio rd = new Radio();
        rd.setCurrentVolumeRadioStation(140);
        int expected = 100;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }


    // проверяем, если установили НИЖЕ Минимальной громкости - устанавливаем минималь  = 0
    // - НЕ допустимо все, что не попадает в интервал от 0 до 10
    @Test
    public void shouldNotSetMinVolume() {
        Radio rd = new Radio();
        rd.setCurrentVolumeRadioStation(-22);
        int expected = 0;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // следующая громкость в диапазоне от 0 до 9
    @Test
    public void shouldNextVolume09() {
        Radio rd = new Radio();
        rd.setToMaxVolume();
        rd.incVolume(9);
        int expected = 10;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // следующая громкость = 10
    @Test
    public void shouldNextVolume10() {
        Radio rd = new Radio();
        rd.setToMaxVolume();
        rd.incVolume(100);
        int expected = 100;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // следующая громкость > 10
    @Test
    public void shouldNextVolumeHigh10() {
        Radio rd = new Radio();
        rd.setToMaxVolume();
        rd.incVolume(150);
        int expected = 100;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    //  предыдующая громкость в диапазоне от 1 до 10
    @Test
    public void shouldPrevVolume110() {
        Radio rd = new Radio();
        rd.setToMinVolume();
        rd.decVolume(9);
        int expected = 8;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // предыдующая громкость = 0
    @Test
    public void shouldPrevVolume0() {
        Radio rd = new Radio();
        rd.setToMinVolume();
        rd.decVolume(0);
        int expected = 0;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // предыдующая громкость > 10
    @Test
    public void shouldPrevVolumeHigh10() {
        Radio rd = new Radio();
        rd.setToMinVolume();
        rd.decVolume(150);
        int expected = 100;
        int actual = rd.getCurrentVolumeRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    // -----------------------------
    // ТЕСТЫ - Громкость звука - КОНЕЦ
    // -----------------------------

}
