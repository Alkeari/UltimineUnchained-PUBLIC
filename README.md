# Ultimine Unchained

FTB Ultimine skips blocks harder than the one you clicked, and charges a point of durability for every block it breaks. Ultimine Unchained mines the whole shape your tool can handle and caps what one operation costs you.

> **One file per loader covers Minecraft 1.20.1 to 1.21.1 wherever FTB Ultimine runs. Needs FTB Ultimine.**

---

## Availability

- [Nexus Mods](https://www.nexusmods.com/minecraft/mods/1291)
- [Modrinth](https://modrinth.com/project/rGNPldmX)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/ultimine-unchained)

## What It Does

This is a Mixin patch for FTB Ultimine, not a vein-mining mod of its own. Every shape, key and target still comes from FTB Ultimine. It changes three things about what an operation does.

- **It respects your shape** - FTB Ultimine compares every block against the first one you targeted and skips anything harder, even when your tool would mine it fine. That check is suppressed by default.
- **Truly unbreakable blocks are still skipped** - bedrock, barriers, anything with a negative destroy speed, whatever the setting says.
- **Durability costs what you decide** - one flat cost in block-break equivalents for the whole operation, or a percentage of the blocks actually broken.
- **Unbreaking still counts** - each point of calculated damage is rolled against the enchantment, the same as vanilla tool damage.
- **One operation can never gut a tool** - the cost is capped at a percentage of maximum durability, 25% by default, so a 2000-durability tool loses at most 500 in one go.
- **And never breaks one** - the cost stops one point short of destroying the tool. Creative players pay nothing.

---

## Requirements

- Minecraft 1.20.1, 1.20.4, 1.20.5, 1.20.6, 1.21 or 1.21.1 on Fabric.
- Minecraft 1.20.1 or 1.20.4 on Forge, including the NeoForge 1.20.1 fork.
- Minecraft 1.20.4, 1.20.6, 1.21 or 1.21.1 on NeoForge.
- Not Minecraft 1.20.2 or 1.20.3, nor 1.20.5 on NeoForge: FTB Ultimine has no build for them.
- FTB Ultimine for your Minecraft version and loader. This mod does nothing without it, and FTB Ultimine brings its own requirements, FTB Library and Architectury API among them.
- Fabric API and Cloth Config on Fabric, with Fabric Loader 0.14.23 or later on 1.20.1, 0.15.11 or later on 1.20.4 to 1.20.6, and 0.19.2 or later on 1.21 and 1.21.1.
- Forge 47.1 or later on 1.20.1, and 49 or later on 1.20.4.
- NeoForge 20.4 or later on 1.20.4, 20.6 or later on 1.20.6, and 21.0 or later on 1.21 and 1.21.1.
- Java 17 or later on Minecraft 1.20.1 to 1.20.4, and Java 21 or later from 1.20.5.

## Installation

1. Install your loader and FTB Ultimine with its requirements, plus Fabric API and Cloth Config if you are on Fabric.
2. Ultimine something with mixed block hardness. The whole shape breaks, and the tool costs at most one point.

## Configuration

On Fabric, edit `config/ultimineunchained.json`. On Forge and NeoForge, edit `<world>/serverconfig/ultimineunchained-server.toml`, which is per world and synced to clients, and `config/ultimineunchained-common.toml` for `check_for_updates`. There is no in-game settings screen on any loader.

| Setting | Default | What it does |
|---|---|---|
| `allow_harder_blocks` | `true` | Suppresses the harder-block skip, so every tool-compatible block in the shape breaks. |
| `durability_percentage` | `0` | Fraction of blocks broken that counts toward durability. Overrides the flat cost once above 0. |
| `durability_flat_blocks` | `1` | Flat cost per operation in block-break equivalents, 0 to 32768. Used while the percentage is 0. |
| `durability_cap_percent` | `25` | The most one operation may take, as a percentage of maximum durability, whatever the settings above ask for. |
| `check_for_updates` | `true` | Once per game start, reads https://alkeari.com/updates/ultimine-unchained.json and, only when a newer Ultimine Unchained is out for your Minecraft version and loader, says so in chat with a link. Nothing else is sent; turn it off to skip the check. |

Fabric names the same settings `allowHarderBlocks`, `durabilityPercentage`, `durabilityFlatBlocks`, `durabilityCapPercent` and `checkForUpdates`. Fabric writes the percentage as a whole number, so `50` means 50%; Forge and NeoForge write it as a decimal, so `0.5` means the same. Setting the flat blocks, the percentage and the cap all to 0 removes durability cost entirely.

## Compatibility

- **Existing worlds.** Add it or remove it whenever you like. On Forge and NeoForge it writes only its settings file into the world's `serverconfig` folder; on Fabric nothing is written to your world.
- **Client or server.** It changes what an operation does, so it belongs wherever FTB Ultimine runs: the server, or the integrated server in singleplayer.
- It works with every tool type and every shape FTB Ultimine supports.
- It does not touch FTB Ultimine's right-click actions, tilling, stripping and harvesting, and does not change how drops are computed. It decides which blocks in the shape break and what the operation costs, nothing else.
- Outside Creative, blocks your tool cannot get drops from are skipped rather than broken.
- If a future FTB Ultimine build changes the method this patches, the game refuses to load rather than running as a silent no-op.

## Support

- Include your Minecraft version, your loader and its version, the mod version, your FTB Ultimine version, and your other mods.

## License

License terms are in the [Alkeari License Agreement](https://gist.github.com/Alkeari/2c6ec0cdf3dafee375b1a00b28ca190a).
