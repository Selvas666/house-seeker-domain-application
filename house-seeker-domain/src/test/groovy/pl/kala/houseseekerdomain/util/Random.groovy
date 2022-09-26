package pl.kala.houseseekerdomain.util

import io.github.xshadov.easyrandom.vavr.VavrRandomizerRegistry
import io.github.xshadov.easyrandom.vavr.factory.VavrRandomizerFactory
import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

class Random {


    private static EasyRandom randomizer = initRandom()

    private static EasyRandom initRandom() {
        VavrRandomizerRegistry vavrRandomizerRegistry = new VavrRandomizerRegistry()
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(500L)
                .collectionSizeRange(2, 5)
                .stringLengthRange(2, 5)
                .randomizerRegistry(vavrRandomizerRegistry)

        EasyRandom randomizer = new EasyRandom(parameters)
        vavrRandomizerRegistry.setEasyRandom(randomizer)
        return randomizer
    }

    static <T> T random(Class<T> clazz) {
        return randomizer.nextObject(clazz)
    }
}
