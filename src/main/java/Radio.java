public class Radio {
    private int currentRadioStation; // текущая станция - сокращаем уровень доступа (private)
    private int currentVolumeRadioStation; // текущая громкость - сокращаем уровень доступа (private)

    // -----------------------------------------
    // МЕТОДЫ - РАДИОСТАНЦИИ - НАЧАЛО
    // -----------------------------------------

    // установка максимальной радиостанции
    public void setToMaxRadioStation() {
        currentRadioStation = 9;
    }

    // установка минимаоной радиостанции
    public void setToMinRadioStation() {
        currentRadioStation = 0;
    }

    // получаем текущую радиостанцию
    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    // устанавливаем радиостанцию в пределах от 0 до 9.
    // если больше 9, или меньше 0 - текущая станция  = 0
    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (newCurrentRadioStation < 0) {
            return;
        }
        if (newCurrentRadioStation > 9) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    // Если текущая радиостанция - 9 и клиент нажал на кнопку next
    //  на пульте, то текущей должна стать 0-ая; в остальных случаях
    //  при нажатии на эту же кнопку радио переключается просто на следующую станцию.
    public void nextRadioStation(int newCurrentRadioStation) {
        setCurrentRadioStation(newCurrentRadioStation);
        if (newCurrentRadioStation == 9) {
            currentRadioStation = 0;
            return;
        }
        currentRadioStation = newCurrentRadioStation + 1;
    }

    // Если текущая радиостанция - 0 и клиент нажал на кнопку prev
    //  на пульте, то текущей должна стать 9-ая; в остальных случаях
    //  радиопереключается просто на предыдущую станцию.
    public void prevRadioStation(int newCurrentRadioStation) {
        setCurrentRadioStation(newCurrentRadioStation);
        if (newCurrentRadioStation == 0) {
            currentRadioStation = 9;
            return;
        }
        currentRadioStation = newCurrentRadioStation - 1;
    }
    // -----------------------------------------
    // МЕТОДЫ - РАДИОСТАНЦИИ - КОНЕЦ
    // -----------------------------------------

    // -----------------------------------------
    // МЕТОДЫ -Громкость звука - НАЧАЛО
    // -----------------------------------------

    // установка максиманую громкость
    public void setToMaxVolume() {
        currentVolumeRadioStation = 10;
    }

    // установка минималную громкость
    public void setToMinVolume() {
        currentVolumeRadioStation = 0;
    }

    // получаем текущюю громкость
    public int getCurrentVolumeRadioStation() {
        return currentVolumeRadioStation;
    }

    // Клиент должен иметь возможность увеличивать и уменьшать уровень громкости звука
    // (в пределах от 0 до 10)
    public void setCurrentVolumeRadioStation(int newCurrentVolumeRadioStation) {
        if (newCurrentVolumeRadioStation < 0) {
            currentVolumeRadioStation = 0;
            return;
        }
        if (newCurrentVolumeRadioStation > 10) {
            currentVolumeRadioStation = 10;
            return;
        }
        currentVolumeRadioStation = newCurrentVolumeRadioStation;
    }

    // Увеличение громкости
    // Если уровень громкости звука достиг максимального значения,
    // то дальнейшее нажатие на + (=вызов метода увеличения громкости на один)
    // не должно ни к чему приводить
    public void incVolume(int newVolume) {
        setCurrentVolumeRadioStation(newVolume);
        if (newVolume >= 10) {
            currentVolumeRadioStation = 10;
            return;
        }
        currentVolumeRadioStation = newVolume + 1;
    }

    // Если уровень громкости звука достиг минимального значения,
    // то дальнейшее нажатие на - (=вызов метода уменьшения громкости на один)
    // не должно ни к чему приводить
    public void decVolume(int newVolume) {
        setCurrentVolumeRadioStation(newVolume);
        if (newVolume <= 0) {
            currentVolumeRadioStation = 0;
            return;
        }
        if (newVolume > 10) {
            return;
        }
        currentVolumeRadioStation = newVolume - 1;
    }


    // -----------------------------------------
    // МЕТОДЫ -Громкость звука - КОНЕЦ
    // -----------------------------------------
}
