/*
 * $Id$
 *
 * Copyright (c) 1998-2008 John Morrison.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */


/*********************************************************
*Name:          Shells
*Filename:      shells.c
*Author:        John Morrison
*Creation Date: 25/12/98
*Last Modified:  24/4/01
*Purpose:
*  Responsable for Shells tracking/collision detect etc.
*********************************************************/

#include <memory.h>
#include "global.h"
#include "shells.h"

/*********************************************************
*NAME:          shellsCreate
*AUTHOR:        John Morrison
*CREATION DATE: 25/12/98
*LAST MODIFIED: 25/12/98
*PURPOSE:
*  Sets up the shells data structure
*
*ARGUMENTS:
*
*********************************************************/
shells shellsCreate(void) {
	return NULL;
}


/*********************************************************
*NAME:          shellsDestroy
*AUTHOR:        John Morrison
*CREATION DATE: 25/12/98
*LAST MODIFIED: 25/12/98
*PURPOSE:
*  Destroys and frees memory for the shells data structure
*
*ARGUMENTS:
*  value - Pointer to the shells data structure
*********************************************************/
void shellsDestroy(shells *value) {
  shells q;

  while (!IsEmpty(*value)) {
    q = *value;
    *value = ShellsTail(q);
    Dispose(q);
  }
}

/*********************************************************
*NAME:          shellsAddItem
*AUTHOR:        John Morrison
*CREATION DATE: 25/12/98
*LAST MODIFIED: 6/3/99
*PURPOSE:
*  Adds an item to the shells data structure. Function
*  also calls the sound playing function
*
*ARGUMENTS:
*  value  - Pointer to the shells data structure
*  x      - X co-ord of the start position
*  y      - Y co-ord of the start position
*  angle  - angle of the shot
*  len    - Length in map units of the item
*  owner  - Who fired the shell
*  onBoat - Was the shell launched from a boat
*********************************************************/
void shellsAddItem(shells *value, BYTE mx, BYTE my, BYTE px, BYTE py, BYTE frame) {
  shells q;

  New (q);
  q->mx = mx;
  q->my = my;
  q->px = px;
  q->py = py;
  q->frame = frame;
  q->next = *value;
  q->prev = NULL;
  if (NonEmpty(*value)) {
    (*value)->prev = q;
  }
  *value = q;
}

/*********************************************************
*NAME:          shellsCalcScreenBullets
*AUTHOR:        John Morrison
*CREATION DATE: 26/12/98
*LAST MODIFIED: 26/12/98
*PURPOSE:
*  Adds items to the sceenBullets data structure if they
*  are on screen
*
*ARGUMENTS:
*  value   - Pointer to the shells data structure
*  sBullet  - The screenBullets Data structure
*  leftPos  - X Map offset start
*  rightPos - X Map offset end
*  top      - Y Map offset end
*  bottom   - Y Map offset end
*********************************************************/
void shellsCalcScreenBullets(shells *value, screenBullets *sBullets, BYTE leftPos, BYTE rightPos, BYTE top, BYTE bottom) {
  shells q;   /* Temp Pointer */


  q = *value;
  while (NonEmpty(q)) {
    if (q->mx >= leftPos && q->mx < rightPos && q->my >= top && q->my < bottom) {
      screenBulletsAddItem(sBullets, (BYTE) (q->mx-leftPos), (BYTE) (q->my-top), q->px, q->py, q->frame); 
    }
    q = ShellsTail(q);
  }
}

