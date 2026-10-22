# Changelog

What changed in Ultimine Unchained, newest first. Only changes you can actually notice are listed:
internal and build work is deliberately left out. This file is the source for the release
notes published on the CurseForge and Modrinth pages.

Entries begin after v1.2.0-1.21.1, the release current when this file was created on
2026-08-14. This repository's earlier history was intentionally cleared, so notes for
releases up to and including that one exist only on the published page.

From v2.0.0 one release serves every Minecraft version the mod supports, so this file is the only changelog.

## Unreleased

- No user-facing changes yet.

## v2.1.0 - 2026-10-20

- Added: Ultimine Unchained tells you in chat when a newer version is out for your Minecraft version and loader, once per game start, and says nothing otherwise; the check_for_updates setting turns it off.

## v2.0.0 - 2026-10-14

- Added: Support for Minecraft 1.20.4, 1.20.5, 1.20.6 and 1.21 on Fabric, 1.20.4, 1.20.6 and 1.21 on NeoForge, and 1.20.4 on Forge, with one download in place of a separate file for each Minecraft version.
- Fixed: On Minecraft 1.20.1 with Fabric the mod had no effect, so FTB Ultimine still skipped harder blocks and charged a point of durability per block; both now work as on every other loader.
- Fixed: On Minecraft 1.20.1 with Fabric, a missing FTB Ultimine is reported at launch, as on every other loader.
- Added: On Minecraft 1.20.1, the durability cap setting limits what one operation can take to a percentage of the tool's maximum durability, 25% by default.
- Changed: The Forge build accepts Forge 47.1 and later, so it also runs on the NeoForge 1.20.1 fork.
- Changed: The mod list shows a new icon, the same artwork as the store tile.
- Removed: Ultimine Unchained no longer requires Architectury API itself; FTB Ultimine still does.

## v1.2.2-1.21.1 - 2026-09-06

- Fixed: The Forge and NeoForge mod list descriptions still showed a long dash; they now use the plain hyphen the previous release said they did.

## v1.2.1-1.21.1 - 2026-09-04

- Changed: The mod list description uses a plain hyphen instead of a long dash.
