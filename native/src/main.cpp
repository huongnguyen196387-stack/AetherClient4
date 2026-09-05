#include <pl/Mod.hpp>

class AetherMod {
public:
    static AetherMod& instance() {
        static AetherMod mod;
        return mod;
    }

    AetherMod()
        : mSelf(*ll::mod::NativeMod::current()) {}

    bool load() {
        return true;
    }

    bool enable() {
        return true;
    }

    bool disable() {
        return true;
    }

    bool unload() {
        return true;
    }

private:
    ll::mod::NativeMod& mSelf;
};

PL_REGISTER_MOD(AetherMod, AetherMod::instance())
