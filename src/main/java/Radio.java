import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {

    private int countRadioStation = 10; // кол-во радиостанций

    private int minRadiostaion = 0; // Номер 1-ой радиостанции

    private int maxRadioStation = 9; // Номер 10-ой (последней) радиостанции

    private int currentRadioStation = maxRadioStation; // текущая радиостанция = максимаоная

    private int minVolumeRadioStation = 0; // мин громкость

    private int maxVolumeRadioStation = 100; // макс. громкость

    private int currentVolumeRadioStation = maxVolumeRadioStation; // текущая громкость - сокращаем уровень доступа (private)

    // устанавливаем радиостанцию в пределах от 0 до 9.
    // если больше 9, или меньше 0 - текущая станция  = 0
    public void setCurrentRadioStation(int newCurrentRadioStation) {
        if (newCurrentRadioStation < minRadiostaion) {
            return;
        }
        if (newCurrentRadioStation > maxRadioStation) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }

    // Если текущая радиостанция - 9 и клиент нажал на кнопку next
    //  на пульте, то текущей должна стать 0-ая; в остальных случаях
    //  при нажатии на эту же кнопку радио переключается просто на следующую станцию.
    public void nextRadioStation(int newCurrentRadioStation) {
        setCurrentRadioStation(newCurrentRadioStation);
        if (newCurrentRadioStation == maxRadioStation) {
            currentRadioStation = minRadiostaion;
            return;
        }
        currentRadioStation = newCurrentRadioStation + 1;
    }

    // Если текущая радиостанция - 0 и клиент нажал на кнопку prev
    //  на пульте, то текущей должна стать 9-ая; в остальных случаях
    //  радиопереключается просто на предыдущую станцию.
    public void prevRadioStation(int newCurrentRadioStation) {
        setCurrentRadioStation(newCurrentRadioStation);
        if (newCurrentRadioStation == minRadiostaion) {
            currentRadioStation = maxRadioStation;
            return;
        }
        currentRadioStation = newCurrentRadioStation - 1;
    }

    // Клиент должен иметь возможность увеличивать и уменьшать уровень громкости звука
    // (в пределах от 0 до 10)
    public void setCurrentVolumeRadioStation(int newCurrentVolumeRadioStation) {
        if (newCurrentVolumeRadioStation < minVolumeRadioStation) {
            currentVolumeRadioStation = minVolumeRadioStation;
            return;
        }
        if (newCurrentVolumeRadioStation > maxVolumeRadioStation) {
            currentVolumeRadioStation = maxVolumeRadioStation;
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
        if (newVolume >= maxVolumeRadioStation) {
            currentVolumeRadioStation = maxVolumeRadioStation;
            return;
        }
        currentVolumeRadioStation = newVolume + 1;
    }

    // Если уровень громкости звука достиг минимального значения,
    // то дальнейшее нажатие на - (=вызов метода уменьшения громкости на один)
    // не должно ни к чему приводить
    public void decVolume(int newVolume) {
        setCurrentVolumeRadioStation(newVolume);
        if (newVolume <= minVolumeRadioStation) {
            currentVolumeRadioStation = minVolumeRadioStation;
            return;
        }
        if (newVolume > maxVolumeRadioStation) {
            return;
        }
        currentVolumeRadioStation = newVolume - 1;
    }


}
