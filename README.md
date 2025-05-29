Проект развернут в облаке с балансировкой нагрузки:

Балансировщик нагрузки (Cloudflare Worker)
https://pastebin-clone.git-voreiadex.workers.dev/
Распределяет запросы между серверами 1 и 2.

Сервер 1
https://pastebin-clone-1.onrender.com

Сервер 2
https://pastebin-clone-nk19.onrender.com

База данных
PostgreSQL на Neon.tech
postgresql://user:pass@ep-sweet-bread-a8vahprh-pooler.eastus2.azure.neon.tech/neondb
Используется обоими серверами.

flowchart TD
    A[Пользователь] --> B[Cloudflare Worker LB]
    B --> C[Сервер 1: Render]
    B --> D[Сервер 2: Render]
    C & D --> E[(БД: Neon.tech)]

Мониторинг серверов
https://stats.uptimerobot.com/XAOz63nwuc

