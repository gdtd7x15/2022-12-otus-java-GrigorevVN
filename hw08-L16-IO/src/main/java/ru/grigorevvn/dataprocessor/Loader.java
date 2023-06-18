package ru.grigorevvn.dataprocessor;

import ru.grigorevvn.model.Measurement;

import java.util.List;

public interface Loader {

    List<Measurement> load();
}
